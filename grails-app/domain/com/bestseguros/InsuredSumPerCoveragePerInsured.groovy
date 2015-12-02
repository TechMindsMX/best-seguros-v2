package com.bestseguros

class InsuredSumPerCoveragePerInsured {

  Coverage coverage
  Double insuredSum
  InsuredType insured

  static belongsTo = [plan:Plan]

  static constraints = {
    insuredSum min:0d
  }

}
