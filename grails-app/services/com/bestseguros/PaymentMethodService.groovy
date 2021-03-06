package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PaymentMethodService {

  def paymentService

  def addPaymentMethodToPolicy(Policy policy,PaymentMethodCommand paymentMethodCommand){
    if(!policy.payment){
      def paymentTypes = [[PaymentType.CREDIT_CARD,PaymentType.DEBIT_CARD]:new Card(cardNumber:paymentMethodCommand.cardNumber,
                                                                                  cardProvider:paymentMethodCommand.cardProvider),
                          [PaymentType.CHECK,PaymentType.REFERENCED_DEPOSIT]:new BankAccount(bank:paymentMethodCommand.bank,
                                                                                             accountNumber:paymentMethodCommand.accountNumber)]

      def paymentMethod = paymentTypes.find{ it.key.contains(paymentMethodCommand.paymentType) }?.value
      paymentMethod.paymentType = paymentMethodCommand.paymentType
      paymentMethod.periodicity = paymentMethodCommand.periodicity
      paymentMethod.save()

      def payment = paymentService.createPaymentForInstance(paymentMethod)
      policy.payment = payment
      policy.save()
    }
    policy
  }

  def createPaymentForPolicy(Policy policy,def paymentMethod){
    if(paymentMethod.validate()){
      paymentMethod.save()
      def payment = paymentService.createPaymentForInstance(paymentMethod)
      policy.payment = payment
    }
  }

  def checkPaymentMethodForPolicy(Policy policy){
    policy?.payment?.id != null ? true : false
  }

}
