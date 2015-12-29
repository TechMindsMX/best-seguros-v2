package com.bestseguros.bean

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCell
import com.bestseguros.Policy
import com.bestseguros.Insurance
import com.bestseguros.Product
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
      Insurance.findByName(rows[2].getCell(0).stringCellValue)
    }

    def productName = rows[2].getCell(1).stringCellValue

    def product = Product.withTransaction{ status ->
      Product.where{
        name.toLowerCase() == Normalizer.normalize(productName,Form.NFD).replaceAll(/\p{InCombiningDiacriticalMarks}+/,'')
        insurance.id == insurance.id
      }
    }

    def policy = new Policy()
  }

}
