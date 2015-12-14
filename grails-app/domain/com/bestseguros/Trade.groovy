package com.bestseguros

class Trade {

  String name
  
  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    name blank:false 
  }

}
