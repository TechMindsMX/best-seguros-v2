package com.bestseguros

class InsuranceCostPerInsured {

  Double insuranceCost
  InsuredType insured

  static constraints = {
    insuranceCost min:0d
  }

}
