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
      def policy = policyInfo.policy      

      if(policyService.isThePolicyValid(policy)){
        policy.save()
        savedPolicies << [policy:policy,paymentMethod:policyInfo.paymentMethod]
      }
      else{
        notificationService.sendPolicyError(policy)
      }
    }

    savedPolicies
  }

  def savePaymentMethod(Exchange exchange){
    def policies = []
    def policiesWithPaymentMethod = exchange.in.getBody(ArrayList.class)
    policiesWithPaymentMethod.each{ policyWithPaymentMethod ->
      def policy = policyWithPaymentMethod.policy 
      paymentMethodService.createPaymentForPolicy(policy,policyWithPaymentMethod.paymentMethod)

      if(paymentMethodService.checkPaymentMethodForPolicy(policy)){
        policyService.updatePolicyStatus(policy)
        policies << policy
      }
    }

    policies
  }

  def removeInvalidPolicies(def policies){
    policies.each{ policy ->
      if(policy.policyStatus != PolicyStatus.FINISHED){
        policy.delete()
      }
    }
    policies
  }

}
