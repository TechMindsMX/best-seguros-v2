package com.bestseguros

class Product {

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
