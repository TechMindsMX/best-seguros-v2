package com.bestseguros

enum CardProvider{
  VISA("Visa"),
  MASTER_CARD("Master Card"),
  AMEX("American Express")

  final String value
  CardProvider(String value){ this.value = value }

  String getKey(){  name()  }
}
