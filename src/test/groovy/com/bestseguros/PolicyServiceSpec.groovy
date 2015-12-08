package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(PolicyService)
@Mock([Policy,Plan,Product,InsuredForPlan,Insured])
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
      def plan = new Plan(name:"un nuevo plan");

      insureds.each{ insured ->
        plan.addToInsureds(insured)
      }

      plan.save(validate:false)
    and:"the policy"
      def savedInsureds = _savedInsureds
      def policy = new Policy(plan:plan)
      savedInsureds.each{ savedInsured ->
        policy.addToInsureds(savedInsured)
      }
      policy.save()
    when:
      def savedAndUnsavedInsureds = service.findSavedAndUnsavedInsuredsForPolicy(policy)
    then:
      savedAndUnsavedInsureds.unsavedInsureds.values().flatten().size() == _unsavedSize
      savedAndUnsavedInsureds.savedInsureds.values().flatten().size() == _savedSize
    where:
    _insureds                                                                                         |  _savedInsureds                                   | _unsavedSize || _savedSize
    [new InsuredForPlan(insured:InsuredType.PRINCIPAL)]                                               |  []                                               | 1            || 0
    [new InsuredForPlan(insured:InsuredType.PRINCIPAL),
     new InsuredForPlan(insured:InsuredType.CHILD),
     new InsuredForPlan(insured:InsuredType.CHILD)]                                                   |  []                                               | 3            || 0
    [new InsuredForPlan(insured:InsuredType.PRINCIPAL),
     new InsuredForPlan(insured:InsuredType.CHILD)]                                                   |  [new Insured(insuredType:InsuredType.PRINCIPAL)] | 1            || 1 
  }

}
