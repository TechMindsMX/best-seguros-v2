package com.bestseguros

class InsuredSumPerCoveragePerInsured {

  Coverage coverage
  Double insuredSum
  InsuredType insured
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    insuredSum min:0d
  }

}
