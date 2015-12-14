package com.bestseguros

class Benefit {

  String name
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false
  }

}
