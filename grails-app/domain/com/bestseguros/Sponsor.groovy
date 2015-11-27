package com.bestseguros

class Sponsor {

  String name

  static constraints = {
    name blank:false,size:0..150,nullable:false
  }

}
