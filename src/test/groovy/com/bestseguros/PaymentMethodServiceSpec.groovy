package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@Mock([Policy,Card,BankAccount,Payment,Bank])
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

  Should "create the payment for the policy"(){
    given:"the policy"
      def policy = new Policy(policyStatus:PolicyStatus.CREATED)
      def bank = new Bank(name:"NAFIN")
      bank.save()
    and:"the payment service"
      def paymentService = Mock(PaymentService)
      def paymentMethod = _paymentMethod
      service.paymentService = paymentService
    when:
      def policyWithPayment = service.createPaymentForPolicy(policy,paymentMethod)
    then:
      1 * paymentService.createPaymentForInstance(_) >> { pm -> def payment = new Payment(paymentMethodRef:1,type:pm.class.simpleName)
                                                                payment.save()
                                                                payment
                                                         }
      policyWithPayment.payment.id
    where:
      _paymentMethod << [new BankAccount(accountNumber:"123456789012345",paymentType:PaymentType.CHECK,periodicity:Periodicity.ANNUAL,bank:new Bank(name:"NAFIN").save()),
                         new Card(cardNumber:"123456789012345",cardProvider:CardProvider.VISA,paymentType:PaymentType.CREDIT_CARD,periodicity:Periodicity.MONTHLY)]
  }

  Should "check if the policy has a payment method"(){
    given: "the policy"
      def policy = new Policy(policyStatus:PolicyStatus.CREATED)
      policy.save(validate:false)

    and:"the payment method"
      def card = new Card(cardNumber:"123456789012345",
                          cardProvider:CardProvider.VISA,
                          paymentType:PaymentType.CREDIT_CARD,
                          periodicity:Periodicity.MONTHLY)
      card.save()

      def payment = new Payment(paymentMethodRef:card.id,
                                type:card.class.simpleName)
      payment.save()
      policy.payment = payment

    when:
      def itHasPaymentMethod = service.checkPaymentMethodForPolicy(policy)
    then:
      itHasPaymentMethod
  }
}
