package com.bestseguros

class Policy {

  Product product
  PolicyStatus policyStatus
  Plan plan
  static hasMany = [insureds:Insured]
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    product nullable:true
    plan nullable:true
  }

}
