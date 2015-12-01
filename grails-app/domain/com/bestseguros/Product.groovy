package com.bestseguros

class Product {

  String uuid = UUID.randomUUID().toString().replaceAll('-','').substring(0,10)
  String name
  Trade trade
  String coin
  String country
  Periodicity periodicity
  Boolean iva
  Insurance insurance
  Sponsor sponsor

  static hasMany = [plans:Plan,
                    rangesAgeByBeneficiary:RangeAgeByBeneficiary]

  static constraints = {
    name blank:false
    coin blank:false
    country blank:false
  }

}
