package com.bestseguros

class Product {

  String uuid = UUID.randomUUID().toString().replaceAll('-','').substring(0,10)
  String name
  Trade trade
  String coin
  String country
  Boolean iva
  Insurance insurance
  Sponsor sponsor

  Date dateCreated
  Date lastUpdated

  static hasMany = [plans:Plan,
                    rangesAgeByBeneficiary:RangeAgeByBeneficiary,
                    insuranceCostsPerInsured:InsuranceCostPerInsured]

  static constraints = {
    name blank:false
    coin blank:false
    country blank:false
  }

}
