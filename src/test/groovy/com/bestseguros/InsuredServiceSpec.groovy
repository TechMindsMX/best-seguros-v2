package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(InsuredService)
@Mock([Insured,Policy])
class InsuredServiceSpec extends Specification {

  Should "save an insured for a policy"(){
    given:"the policy"
      def policy = new Policy(policyStatus:PolicyStatus.CREATED).save(validate:false)
    and:"an insured"
      def insured = new Insured(name:"Gamaliel",
                                lastName:"Jiménez",
                                motherLastName:"Garcia",
                                phone:"5548109233",
                                rfc:"JIGE930831",
                                email:"egjimenezg@gmail.com",
                                address:"Bellas Artes 232",
                                country:"México",
                                state:"Distrito Federal",
                                town:"Some Town",
                                colony:"Colony",
                                cp:"57730",
                                city:"México City",
                                insuredType:InsuredType.PRINCIPAL)
      insured.birthDate = new Date()
    when:
      service.addInsuredForPolicy(insured,policy)
    then:
      policy.insureds.size() == 1
      policy.insureds.first().id
  }

  Should "save the contracting party as principal"(){
    given:"the policy and the contracting party insured"
      def policy = new Policy().save(validate:false)
      def insured = new Insured(name:"Gamaliel",
                                lastName:"Jiménez",
                                insuredType:InsuredType.CONTRACTING_PARTY)
    when:
      def service = service.addContratingPartyAndPrincipalForPolicy(insured,policy)
    then:
      policy.insureds.find{ it.insuredType.PRINCIPAL }
  }

}
