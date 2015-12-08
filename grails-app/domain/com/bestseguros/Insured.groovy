package com.bestseguros

class Insured{
  String name
  String lastName
  String motherLastName
  Date birthDate
  String phone
  String rfc
  String email
  String address
  String country
  String state
  String town
  String colony
  String cp
  String city
  InsuredType insuredType

  static constraints = {
    name blank:false
    lastName blank:false
    motherLastName blank:false
    rfc blank:false
    email blank:false
    address blank:false
    country blank:false
    state blank:false
    town blank:false
    colony blank:false
    cp blank:false
    city blank:false
  }

}
