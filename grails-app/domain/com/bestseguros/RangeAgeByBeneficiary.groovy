package com.bestseguros

class RangeAgeByBeneficiary{

  InsuredType insuredType
  Integer minAge
  Integer maxAge
  Integer renewal
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    minAge min:0
    maxAge min:0
    renewal min:0
  }

}
