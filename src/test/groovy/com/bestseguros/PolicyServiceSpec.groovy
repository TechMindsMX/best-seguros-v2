package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(PolicyService)
@Mock([Policy])
class PolicyServiceSpec extends Specification {

  Should "create a new Policy"(){
    when:
      def policy = service.createPolicy()
    then:
      policy.id
  }

}
