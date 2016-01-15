package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@Mock([Policy,Card,BankAccount])
@TestFor(PaymentMethodService)
class PaymentMethodServiceSpec extends Specification {

  Should "add the payment method to the policy"(){
    given: "the policy"
      def policy = new Policy(policyStatys:PolicyStatus.CREATED)

    and:"the payment method"
      def paymentMethod = _paymentMethod
      def paymentService = Mock(PaymentService)
      service.paymentService = paymentService
    when:
      service.addPaymentMethodToPolicy(policy,paymentMethod)
    then:
      1 * paymentService.createPaymentForInstance(_) >> new Payment(paymentMethodRef:1,type:_paymentType)
      policy.payment.type == _paymentType
    where:
      _paymentMethod                                                                                                              || _paymentType
      new PaymentMethodCommand(cardNumber:"012345678912345",paymentType:PaymentType.CREDIT_CARD,periodicity:Periodicity.MONTHLY)  || Card.class.simpleName
      new PaymentMethodCommand(accountNumber:"012345678910",paymentType:PaymentType.CHECK,periodicity:Periodicity.QUARTERLY)      || BankAccount.class.simpleName
  }

}
