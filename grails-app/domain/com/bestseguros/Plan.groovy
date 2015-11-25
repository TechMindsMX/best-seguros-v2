package com.bestseguros

class Plan {

  String name
  Double insuranceCost

  static hasMany = [insuredSums:InsuredSum]

  static constraints = {
    name blank:false
    insuranceCost min:0
  }
}
