package com.bestseguros

class Sponsor {

  String code
  String name
  String country
  String fiscalAddress
  String phone
  String contact
  String rfc

  static constraints = {
    code blank:false,nullable:false
    name blank:false,size:0..150,nullable:false
    country blank:false,size:0..150
    fiscalAddress blank:false,size:0..150
    phone blank:false,size:0..20
    rfc unique:true,blank:false
  }

}
