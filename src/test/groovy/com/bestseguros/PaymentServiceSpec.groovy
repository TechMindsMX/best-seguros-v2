package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should
import spock.lang.FailsWith

@TestFor(PaymentService)
@Mock([Payment,Bank,BankAccount])
class PaymentServiceSpec extends Specification {

  Should "create a payment for instance with interface payment Method"(){
    given:
      def bank = new Bank(name:"BAJIO")
      def bankAccount = new BankAccount(bank:bank,
                                        accountNumber:"An account",
                                        paymentType:PaymentType.REFERENCED_DEPOSIT,
                                        periodicity:Periodicity.MONTHLY)
      bankAccount.save()
    when:
      def payment = service.createPaymentForInstance(bankAccount)
    then:
      assert payment.paymentMethodRef == bankAccount.id
      assert payment.type == BankAccount.class.simpleName
  }

  @FailsWith(RuntimeException)
  Should "not create a payment for instance without interface payment Method"(){
    given:"an instance"
      def policy = new Policy(policyStatus:PolicyStatus.CREATED)
      policy.save()
    when:
      def payment = service.createPaymentForInstance(policy)
    then:
      !payment.id
  }
}
