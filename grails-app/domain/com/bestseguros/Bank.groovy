package com.bestseguros

class Bank {
  
  String code
  String name

  static constraints = {
    code blank:false
    name blank:false,size:0.250
  }

}
