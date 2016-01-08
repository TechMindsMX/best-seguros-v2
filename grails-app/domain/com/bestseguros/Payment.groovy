package com.bestseguros

class Payment{

  Long paymentMethodRef
  String type

  static constraints = {
    paymentMethodRef nullable:false,blank:false
    type nullable:false,blank:false
  }

}
