package com.bestseguros

enum PaymentType{
  CREDIT_CARD("Tarjeta de crédito"),
  DEBIT_CARD("Tarjeta de débito"),
  CHECK("Cheque"),
  REFERENCED_DEPOSIT("Clabe")

  final String value
  PaymentType(String value){ this.value = value }

  String getKey(){ name() }
}
