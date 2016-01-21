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

      if(paymentMethodService.checkPaymentMethodForPolicy(policy))
        policyService.updatePolicyStatus(policy)

      policies << policy
    }

    policies
  }

  def removeInvalidPolicies(Exchange exchange){
    def policies = exchange.in.getBody(ArrayList.class)
    def validPolicies = []

    policies.each{ policy ->
      if(policy.policyStatus != PolicyStatus.FINISHED){
        notificationService.sendPolicyError(policy,true)
        policy.delete()
      }
      else{
        policy.save()
        validPolicies << policy
      }
    }
    validPolicies
  }

}
