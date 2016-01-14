package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PaymentMethodService {

  def addPaymentMethodToPolicy(Policy policy,PaymentMethodCommand paymentMethodCommand){
    def paymentTypes = [[PaymentType.CREDIT_CARD,PaymentType.DEBIT_CARD]:new Card(cardNumber:paymentMethodCommand.cardNumber,
                                                                                  cardProvider:paymentMethodCommand.cardProvider),
                        [PaymentType.CHECK,PaymentType.REFERENCED_DEPOSIT]:new BankAccount(bank:paymentMethodCommand.bank,
                                                                                           accountNumber:paymentMethodCommand.accountNumber)]
    def paymentMethod = paymentTypes.find{ it.key.contains(paymentMethodCommand.paymentType) }?.value
    paymentMethod.paymentType = paymentMethod.paymentType
    paymentMethod.periodicity = paymentMethod.periodicity
    def payment = new Payment(paymentMethodRef:paymentMethod.id,
                              type:paymentMethod.class.simpleName)
    policy.payment = payment
    payment
  }

}
