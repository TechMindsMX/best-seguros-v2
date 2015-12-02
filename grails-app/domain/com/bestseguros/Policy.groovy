package com.bestseguros

class Policy {

  Product product
  PolicyStatus policyStatus
  static hasMany = [insureds:Insured]

  static constraints = {
    product nullable:true
  }

}
