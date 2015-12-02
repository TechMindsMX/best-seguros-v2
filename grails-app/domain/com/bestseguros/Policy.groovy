package com.bestseguros

class Policy {

  Product product
  PolicyStatus policyStatus
  Plan plan
  static hasMany = [insureds:Insured]

  static constraints = {
    product nullable:true
    plan nullable:true
  }

}
