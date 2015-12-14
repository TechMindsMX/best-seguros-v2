package com.bestseguros

class Insurance {

  String name
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false,size:0..150,nullable:false
  }

}
