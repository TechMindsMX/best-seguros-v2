package com.bestseguros

class BankAccount implements PaymentMethod{

  Bank bank
  String accountNumber
  PaymentType paymentType
  Periodicity periodicity

  static constraints = {
    accountNumber nullable:false
  }

}
