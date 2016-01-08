package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PaymentService {

  def createResponseForInstance(instance){
    if(!PaymentMethod.class.isAssignableFrom(instance.class))
      throw new Exception("PaymentMethod is not assignable from ${instance.class}")

    def payment = new Payment(paymentMethodRef:instance.id,
                              type:instance.class.simpleName)
    payment.save()
    payment
  }

}
