package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(PolicyService)
@Mock([Policy,Plan,Product])
class PolicyServiceSpec extends Specification {

  Should "create a new Policy"(){
    when:
      def policy = service.createPolicy()
    then:
      policy.id
  }

  Should "save the product and the plan of the policy"(){
    given:"the product"
      def plan = new Plan(name:"Titular",
                         insureds:[InsuredType.PRINCIPAL]).save(validate:false)

      def product = new Product(name:"Renta diaria por Hospitalización")
      product.addToPlans(plan)
      product.save(validate:false)
    and:"the policy"
      def policy = new Policy(policyStatus:PolicyStatus.CREATED).save()
    when:
      def policyWithProduct = service.addProductAndPlanToPolicy(policy.id,[product:product.id,plan:plan.id])
    then:
      policyWithProduct.product.id
      policyWithProduct.plan.id
  }

}
