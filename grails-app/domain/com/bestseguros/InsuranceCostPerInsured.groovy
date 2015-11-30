package com.bestseguros

class InsuranceCostPerInsured {

  Double insuredCost
  InsuredType insured

  static constraints = {
    insuredCost min:0d
  }

}
