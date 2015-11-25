package com.bestseguros

class Product {

  String name
  String code
  Trade trade
  String coin
  String country
  Periodicity periodicity
  Boolean iva

  static belongsTo = [insurance:Insurance,
                      sponsor:Sponsor]

  static hasMany = [plans:Plan,
                    beneficiaryCoverages:BeneficiaryCoverage]

  static constraints = {
    name blank:false
    code blank:false
    coin blank:false
    country blank:false
  }

}
