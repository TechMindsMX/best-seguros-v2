package com.bestseguros

class Bank {

  String name

  static constraints = {
    name blank:false,size:0..250
  }

}
