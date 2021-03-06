package com.bestseguros.bean

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.hssf.usermodel.HSSFDateUtil
import com.bestseguros.Policy
import com.bestseguros.PolicyStatus
import com.bestseguros.Insurance
import com.bestseguros.Product
import com.bestseguros.InsuredType
import com.bestseguros.Insured
import com.bestseguros.Payment
import com.bestseguros.PaymentType
import com.bestseguros.Periodicity
import com.bestseguros.Card
import com.bestseguros.CardProvider
import com.bestseguros.BankAccount
import com.bestseguros.Bank
import java.text.Normalizer
import java.text.Normalizer.Form

class SplitterBean{

  def splitBody(InputStream body){
    XSSFWorkbook workbook = new XSSFWorkbook(body)
    XSSFSheet sheet = workbook.getSheetAt(0)

    def dataRows = []
    def policies = []

    sheet.rowIterator().each{ row ->
      if(row.getCell(0).getStringCellValue() == "Producto")
        dataRows << []

      dataRows.last() << row
    }

    dataRows.each{ rows ->
      policies << getPolicyFromRows(rows)
    }

    policies
  }

  private def getPolicyFromRows(def rows){
    def insurance = Insurance.withTransaction{ status ->
      Insurance.findByNameIlike("%${rows[2].getCell(0).stringCellValue}%")
    }

    def product = null
    def plan = null
    def insureds = []

    def planName = rows[2].getCell(2)?.stringCellValue
    def productName = normalizeString(rows[2].getCell(1)?.stringCellValue)

    Product.withTransaction{ status ->
      product = Product.list().find{ p ->
        normalizeString(p.name).matches(".*${productName}.*") && p.insurance.id == insurance.id
      }

      plan = product?.plans?.find{ p ->
        p.name == planName
      }
    }

    def contractingPartyInfoRow = rows[rows.findIndexOf{ it.getCell(0)?.stringCellValue == "Contratante" }+2]
    def contractingPartyInfo = getInsuredInfoFromRow(contractingPartyInfoRow,contractingPartyInfoRow.firstCellNum,contractingPartyInfoRow.lastCellNum-1)
    def principalCell = contractingPartyInfo.remove(contractingPartyInfo.size() - 1)

    insureds << createInsured(contractingPartyInfo,InsuredType.CONTRACTING_PARTY)

    if(isPrincipal(principalCell))
      insureds << createInsured(contractingPartyInfo,InsuredType.PRINCIPAL)

    def insuredsRowIndex = rows.findIndexOf{ it.getCell(0)?.stringCellValue == "Asegurados" } + 2
    def insuredsRows = []

    if(insuredsRowIndex < rows.size())
      insuredsRows += rows[insuredsRowIndex..(rows.size()-1)]

    getInsuredsFromRows(insuredsRows).each{ insured ->
      insureds << insured
    }

    def policy = new Policy(product:product,
                            policyStatus:PolicyStatus.CREATED,
                            plan:plan)

    insureds.each{ insured ->
      policy.addToInsureds(insured)
    }

    [paymentMethod:getPaymentMethodFromRow(rows[2]),policy:policy]
  }

  private String normalizeString(String notNormalizedString){
    notNormalizedString ? Normalizer.normalize(notNormalizedString?.toLowerCase() ?: "",Form.NFD).replaceAll(/\p{InCombiningDiacriticalMarks}+/,'') : null
  }

  private def getInsuredInfoFromRow(XSSFRow row,Integer firstCell,Integer lastCell){
    def insuredInfo = []

    firstCell.upto(lastCell){ i ->
      insuredInfo << getCellValue(row.getCell(i))
    }

    insuredInfo
  }

  private Boolean isPrincipal(String principal){
    principal == "SI" ? true : false
  }


  private def getInsuredsFromRows(def rows){
    def insuredType
    def insuredInfo
    def insureds = []

    rows.each{ row ->
      insuredType = InsuredType.values().find{ it.value == row.getCell(0)?.stringCellValue }
      insuredInfo = getInsuredInfoFromRow(row,row.firstCellNum+1,row.lastCellNum)
      insureds << createInsured(insuredInfo,insuredType)
    }

    insureds
  }

  private def getCellValue(XSSFCell cell){

    if(cell?.cellType == XSSFCell.CELL_TYPE_NUMERIC){
      if(HSSFDateUtil.isCellDateFormatted(cell))
        return cell?.dateCellValue ?: ""

      cell.setCellType(XSSFCell.CELL_TYPE_STRING)
    }

    cell?.stringCellValue ?: ""
  }

  def createInsured(def insuredRow,InsuredType insuredType){
    new Insured(name:insuredRow[0],
                lastName:insuredRow[1],
                motherLastName:insuredRow[2],
                birthDate:insuredRow[3],
                phone:insuredRow[4],
                rfc:insuredRow[5],
                email:insuredRow[6],
                cp:insuredRow[7],
                address:insuredRow[8],
                country:insuredRow[9],
                state:insuredRow[10],
                town:insuredRow[11],
                colony:insuredRow[12],
                city:insuredRow[13],
                insuredType:insuredType)
  }

  private def getPaymentMethodFromRow(XSSFRow row){
    def accountCardNumberCell = row.getCell(6)
    accountCardNumberCell?.setCellType(XSSFCell.CELL_TYPE_STRING)
    def accountCardNumber = new BigDecimal(accountCardNumberCell?.stringCellValue ?: "0").toPlainString()

    def paymentMethods = [[PaymentType.CREDIT_CARD,PaymentType.DEBIT_CARD]:new Card(cardNumber:accountCardNumber),
                          [PaymentType.CHECK,PaymentType.REFERENCED_DEPOSIT]:new BankAccount(accountNumber:accountCardNumber)]

    def addBankOrCardProvider = [(BankAccount.class.simpleName):{ paymentMethod,bankName ->
                                                                Bank.withTransaction{ session ->
                                                                  paymentMethod.bank = Bank.findByName(bankName ?: "")
                                                                }
                                                             },
                                  (Card.class.simpleName):{ paymentMethod, cardProvider ->
                                                              paymentMethod.cardProvider = CardProvider.values().find{ normalizeString(it.value) == normalizeString(cardProvider) }
                                                          }]

    def paymentType = PaymentType.values().find{ normalizeString(it.value) == normalizeString(row.getCell(3)?.stringCellValue) }
    def periodicity = Periodicity.values().find{ normalizeString(it.value) == normalizeString(row.getCell(4)?.stringCellValue) }
    def paymentMethod = paymentMethods.find{ it.key.contains(paymentType) }?.value
    def cardProviderOrBank = row.getCell(5)?.stringCellValue

    if(paymentMethod){
      paymentMethod.paymentType = paymentType
      paymentMethod.periodicity = periodicity
      addBankOrCardProvider[paymentMethod.class.simpleName](paymentMethod,cardProviderOrBank)
    }

    paymentMethod
  }

}
