package com.bestseguros

class Card implements PaymentMethod{

  String cardNumber
  CardProvider cardProvider
  PaymentType paymentType
  Periodicity periodicity

  Date dateCreated
  Date lastUpdated

  static constraints = {
    cardNumber blank:false,nullable:false,size:15..16
  }

}
