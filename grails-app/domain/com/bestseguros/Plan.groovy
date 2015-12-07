package com.bestseguros

class Plan {

  String name
  Integer maximumInsuredsNumber

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
