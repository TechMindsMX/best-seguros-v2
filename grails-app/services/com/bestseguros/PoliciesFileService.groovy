package com.bestseguros

import grails.transaction.Transactional
import org.apache.camel.*

@Transactional
class PoliciesFileService {

  def policyService
  def paymentService
  def paymentMethodService
  def notificationService

  def savePolicies(Exchange exchange){
    def policiesWithInfo = exchange.getIn().getBody(ArrayList.class)
    def savedPolicies = []
    policiesWithInfo.each{ policyInfo ->
      def policy = paymentMethodService.createPaymentForPolicy(policyInfo.policy, policyInfo.paymentMethod)

      if(policyService.isThePolicyValid(policy)){
        if(paymentMethodService.checkPaymentMethodForPolicy(policy)){
          policyService.updatePolicyStatus(policy)
          policy.save()
          savedPolicies << policy
        }
        else{
          notificationService.sendPolicyError(policy)
        }
      }
    }

    savedPolicies
  }

}
