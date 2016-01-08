package com.bestseguros

class BankAccount implements PaymentMethod{

  Bank bank
  String accountNumber
  PaymentType paymentType
  Periodicity periodicity

  Date dateCreated
  Date lastUpdated

  static constraints = {
    accountNumber nullable:false
  }

}
