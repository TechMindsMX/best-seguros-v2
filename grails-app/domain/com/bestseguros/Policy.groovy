package com.bestseguros

class Policy {

  String uuid = UUID.randomUUID().toString().replaceAll('-','').substring(0,10)
  Product product
  PolicyStatus policyStatus
  Plan plan
  Payment payment
  static hasMany = [insureds:Insured]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    product nullable:true
    plan nullable:true
    payment nullable:true
  }

}
