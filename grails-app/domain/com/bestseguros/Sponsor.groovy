package com.bestseguros

class Sponsor {

  String name

  Date dateCreated
  Date lastUpdated 

  static constraints = {
    name blank:false,size:0..150,nullable:false
  }

}
