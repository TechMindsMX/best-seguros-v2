package com.bestseguros

import grails.validation.Validateable

class PaymentMethodCommand implements Validateable{
  String cardNumber
  String accountNumber
  PaymentType paymentType
  Periodicity periodicity
  CardProvider cardProvider
  Bank bank
  Policy policy
}
