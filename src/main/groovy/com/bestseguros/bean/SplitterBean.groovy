package com.bestseguros.bean

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import com.bestseguros.Policy
import com.bestseguros.PolicyStatus
import com.bestseguros.Insurance
import com.bestseguros.Product
import com.bestseguros.InsuredType
import com.bestseguros.Insured
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

  private Policy getPolicyFromRows(def rows){
    def insurance = Insurance.withTransaction{ status ->
      Insurance.findByNameIlike("%${rows[2].getCell(0).stringCellValue}%")
    }

    def product = null
    def plan = null

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


    def contractingPartyInfoRow = rows[rows.indexOf(rows.find{ it.getCell(0)?.stringCellValue == "Contratante" })+2]
    def contractingPartyInfo = getInsuredInfoFromRow(contractingPartyInfoRow,contractingPartyInfoRow.firstCellNum,contractingPartyInfoRow.lastCellNum-1)

    def policy = new Policy(product:product,
                            policyStatus:PolicyStatus.CREATED,
                            plan:plan)
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

  private def getCellValue(XSSFCell cell){
    if(cell.cellType == XSSFCell.CELL_TYPE_NUMERIC)
      cell.setCellType(XSSFCell.CELL_TYPE_STRING)

    cell.stringCellValue
  }

  def createInsured(def insuredRow,InsuredType insuredType){
    new Insured(name:insuredRow[0],
                lastName:insuredRow[1],
                motherLastName:insuredRow[2],
                phone:insuredRow[3],
                rfc:insuredRow[4],
                email:insuredRow[5],
                address:insuredRow[6],
                insuredType:insuredRow[7])
  }

}
