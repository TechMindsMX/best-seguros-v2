package com.bestseguros

class Policy {

  Product product
  static hasMany = [insureds:Insured]

  static constraints = {

  }

}
