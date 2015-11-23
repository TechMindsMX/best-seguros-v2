package com.bestseguros

class Coverage {
  
  String code
  String name

  static constraints = {
    code blank:false,nullable:true 
    name blank:false,nullable:true 
  }

}
