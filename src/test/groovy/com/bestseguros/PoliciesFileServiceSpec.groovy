package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

import org.apache.camel.*
import org.apache.camel.impl.*

import java.lang.Void as Should

@TestFor(PoliciesFileService)
@Mock([Policy,Plan,Insurance,Product,InsuredForPlan,Trade,Sponsor])
class PoliciesFileServiceSpec extends Specification {

  Should "save the policy from the exchange"(){
    given:"the plan"
      def insuredForPlan = new InsuredForPlan(insured:InsuredType.PRINCIPAL)
      insuredForPlan.save()

      def plan = new Plan(name:"Titular")
      plan.addToInsureds(insuredForPlan)
      plan.save()

    and:"the product"
      def trade = new Trade(name:"Vida").save()
      def insurance = new Insurance(name:"Pan-American México, Compañia de Seguros").save()
      def sponsor = new Sponsor(name:"Sponsor 1").save()

      def product = new Product(name:"Renta diaria por Hospitalización",
                                trade:trade,
                                coin:"Nacional",
                                country:"México",
                                iva:false,
                                insurance:insurance,
                                sponsor:sponsor)

      product.save()

    and:"the insureds"
      def insureds = [createInsured(InsuredType.CONTRACTING_PARTY),createInsured(InsuredType.PRINCIPAL)]

    and:"the policy"
      def policy = new Policy(product:product,
                              policyStatus:PolicyStatus.CREATED)

    and:"the exchange"
      CamelContext context = new DefaultCamelContext()
      def exchange = new DefaultExchange(context)
      exchange.in.setBody([policy])

    and:"the policy service"
      def policyService = Mock(PolicyService)
      service.policyService = policyService
    when:
      service.savePolicies(exchange)
    then:
      Policy.list().size() == 1
      1 * policyService.isThePolicyValid(_) >> true
  }

  private def createInsured(InsuredType insuredType){
    new Insured(name:"Gamaliel",
               lastName:"Jiménez",
               motherLastName:"García",
               birthDate:new Date(),
               phone:"5523007633",
               rfc:"JIGE9331083RZ1",
               email:"egjimenezg@gmail.com",
               address:"Bellas Artes 232 ",
               country:"México",
               state:"México",
               town:"Nezahualcoyotl",
               colony:"Metropolitana 2da sección",
               cp:"57840",
               city:"Nezahualcoyotl",
               insuredType:insuredType)
  }

}
