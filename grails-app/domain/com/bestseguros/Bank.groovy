package com.bestseguros

class Bank {

  String name
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false,size:0..250
  }

}
