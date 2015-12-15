package com.bestseguros
import org.grails.databinding.BindingFormat

class Insured{
  String name
  String lastName
  String motherLastName
  @BindingFormat("dd/MM/yyyy")
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

  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false
    lastName blank:false
    motherLastName blank:false
    rfc blank:false,nullable:true,size:10..15,matches:/[A-Z]{4}([0-9]{2})(1[0-2]|0[1-9])([0-3][0-9])([A-Z0-9]{3})$/
    phone bank:false,matches:/[0-9]+/
    email blank:false, email:true
    address blank:false
    country blank:false
    state blank:false
    town blank:false
    colony blank:false
    cp blank:false
    city blank:false
  }

}
