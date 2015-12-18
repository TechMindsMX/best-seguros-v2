package com.bestseguros
// TODO:Poner code en los enums
enum InsuredType{
  PRINCIPAL("Titular"),
  SPOUSE("Conyugue"),
  CHILD("Hijo"),
  CONTRACTING_PARTY("Contratante")

  final String value
  InsuredType(String value){ this.value = value}

  String getKey(){ name() }

}
