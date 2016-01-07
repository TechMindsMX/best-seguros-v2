package com.bestseguros

class Payment{

  Long responseRef
  String type

  static constraints = {
    responseRef nullable:false
  }

}
