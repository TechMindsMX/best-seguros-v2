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

  Should "get the unsaved insured for the policy"(){
    given:"the plan"
      def insureds = _insureds
      def plan = new Plan(name:"un nuevo plan",
                          maximumInsuredsNumber:_maximumInsuredsNumber);

      insureds.each{ insured ->
        plan.addToInsureds(insured)
      }

      plan.save(validate:false)
    and:"the policy"
      def savedInsureds = _savedInsureds
      def policy = new Policy(plan:plan)
      policy.save()
    when:
      def unsavedInsureds = service.findUnsavedInsuredsForPolicy(policy)
    then:
      unsavedInsureds.values().flatten().size() == _size
    where:
    _insureds                                 | _maximumInsuredsNumber  | _savedInsureds || _size
    [InsuredType.PRINCIPAL]                   | 1                       | []             || 1
    [InsuredType.PRINCIPAL,InsuredType.CHILD] | 3                       | []             || 3
  }

}
