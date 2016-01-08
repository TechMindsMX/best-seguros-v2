package com.bestseguros

class Card implements PaymentMethod{

  String cardNumber
  CardProvider cardProvider
  PaymentType paymentType

  static constraints = {
  }

}
