package com.bestseguros

class Plan {

  String name

  static hasMany = [
    coverages:Coverage,
    benefits:Benefit,
    insureds: InsuredType,
    insuredSumsByCoveragePerInsured:InsuredSumPerCoveragePerInsured
  ]

  static belongsTo = [product:Product]

  static constraints = {
    name blank:false
  }

}
