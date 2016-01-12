package com.bestseguros

import grails.transaction.Transactional
import org.apache.camel.*

@Transactional
class PoliciesFileService {

  def policyService

  def savePolicies(Exchange exchange){
    def policies = exchange.getIn().getBody(ArrayList.class)
    def savedPolicies = []

    policies.each{ policy ->
      if(policyService.isThePolicyValid(policy)){
        policy.save()
        savedPolicies << policy
      }
    }

    savedPolicies
  }

}
