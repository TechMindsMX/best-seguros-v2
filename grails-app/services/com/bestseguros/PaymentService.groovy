package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PaymentService {

  def grailsApplication

  def createPaymentForInstance(instance){
    if(!PaymentMethod.class.isAssignableFrom(instance.class))
      throw new Exception("PaymentMethod is not assignable from ${instance.class}")

    def payment = new Payment(paymentMethodRef:instance.id,
                              type:instance.class.simpleName)
    payment.save()
    payment
  }

  def findPaymentInstance(Long paymentId){
    def payment = Payment.get(paymentId)
    def clazz = grailsApplication.getDomainClasses().find{ it.clazz.simpleName == payment.type }.clazz
    def instance = clazz.get(payment.paymentMethodRef)
  }
}
