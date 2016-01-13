package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PaymentMethodService {

  def addPaymentMethodToPolicy(Policy policy,PaymentMethodCommand paymentMethod){
    def paymentTypes = [[PaymentType.CREDIT_CARD,PaymentType.DEBIT_CARD]:new Card(),
                        [PaymentType.CHECK,PaymentType.REFERENCED_DEPOSIT]:new BankAccount()]


  }

}
