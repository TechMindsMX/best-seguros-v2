package com.bestseguros

class InsuranceCostPerInsured {

  Double insuranceCost
  InsuredType insured

  Date dateCreated
  Date lastUpdated

  static constraints = {
    insuranceCost min:0d
  }

}
