package com.bestseguros

import grails.transaction.Transactional
import org.apache.camel.*

@Transactional
class PoliciesFileService {

  def policyService
  def paymentService
  def paymentMethodService

  def savePolicies(Exchange exchange){
    def policiesWithInfo = exchange.getIn().getBody(ArrayList.class)
    def savedPolicies = []
    policiesWithInfo.each{ policyInfo ->
      if(policyService.isThePolicyValid(policyInfo.policy)){
        def policy = paymentMethodService.createPaymentForPolicy(policyInfo.policy,policyInfo.paymentMethod)
        if(paymentMethodService.checkPaymentMethodForPolicy(policy)){
          policy.save()
          savedPolicies << policy
        }
      }

    }

    savedPolicies
  }

}
