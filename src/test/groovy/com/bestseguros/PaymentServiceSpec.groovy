package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

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
      bankAccount.save(validate:false)
    when:
      def response = service.createResponseForInstance(bankAccount)
    then:
      assert response.paymentMethodRef == bankAccount.id
      assert response.type == BankAccount.class.simpleName
  }

}
