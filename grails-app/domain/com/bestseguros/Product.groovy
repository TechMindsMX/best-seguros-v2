package com.bestseguros

class Product {

  String name
  String code
  Trade trade
  String coin
  String country  

  static belongsTo = [insurance:Insurance,sponsor:Sponsor]

  static constraints = {
    name blank:false
    code blank:false
    coin blank:false 
    country blank:false 
  }

}
