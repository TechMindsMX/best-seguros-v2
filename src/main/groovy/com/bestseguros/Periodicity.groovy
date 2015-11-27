package com.bestseguros

// TODO:Poner code en los enums
enum Periodicity{
  MONTHLY("Mensual"),
  QUARTERLY("Trimestral"),
  BIANNUAL("Semestral"),
  ANNUAL("Anual"),
  UNIQUE("Única")

  final String value
  Periodicity(String value){ this.value = value}

  String getKey(){ name() }

}
