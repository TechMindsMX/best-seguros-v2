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
      Insurance.findByNameIlike("%${rows[2].getCell(0).stringCellValue}%")
    }

    println "Insurance ${insurance}"

    def productName = normalizeString(rows[2].getCell(1)?.stringCellValue)

    def product = Product.withTransaction{ status ->
      Product.list().find{ p ->
        normalizeString(p.name).matches(".*${productName}.*") && p.insurance.id == insurance.id
      }
    }

    def policy = new Policy()
  }

  private String normalizeString(String notNormalizedString){
    notNormalizedString ? Normalizer.normalize(notNormalizedString?.toLowerCase() ?: "",Form.NFD).replaceAll(/\p{InCombiningDiacriticalMarks}+/,'') : null
  }

}
