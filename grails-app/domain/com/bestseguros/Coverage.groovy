package com.bestseguros

class Coverage {

  String name
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false,nullable:true
  }

}
