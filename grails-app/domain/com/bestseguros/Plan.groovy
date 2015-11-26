package com.bestseguros

class Plan {

  String name
  Double insuranceCost

  static hasMany = [
    coverages:Coverage,
    benefits:Benefit,
    insureds: InsuredType,
    insuredSumsByCoveragePerInsured:InsuredSumPerCoveragePerInsured
  ]

  static constraints = {
    name blank:false
    insuranceCost min:0d
  }
}
