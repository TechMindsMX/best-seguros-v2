package com.bestseguros

enum PolicyStatus{
  CREATED("Creada"),
  FINISHED("Finalizada")

  final String value
  PolicyStatus(String value){ this.value = value}

  String getKey(){ name() }
}
