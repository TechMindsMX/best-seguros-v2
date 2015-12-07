package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PolicyService {

  def createPolicy(){
    def policy = new Policy(policyStatus:PolicyStatus.CREATED)
    policy.save()
    policy
  }

  def addProductAndPlanToPolicy(Long policyId,Map productInfo){
    def policy = Policy.get(policyId)
    policy.product = Product.get(productInfo.product)
    policy.plan = Plan.get(productInfo.plan)
    policy
  }

  def findUnsavedInsuredsForPolicy(Policy policy){
    def policyInsureds = policy.insureds
    def planInsureds = policy?.plan?.insureds

    def maximumInsuredsNumber = policy.plan.maximumInsuredsNumber
    def unsavedInsureds = [:]

    planInsureds.findAll{ it != InsuredType.CHILD }.each{ insured ->
      if(!policyInsureds.findAll{ it.insuredType == insured })
        unsavedInsureds[insured] = new Insured()
    }

    if(planInsureds.contains(InsuredType.CHILD)){
      def unsavedChildsNumber = maximumInsuredsNumber - (policyInsureds?.size() ?: 0)
      unsavedChildsNumber -= unsavedInsureds.keySet()?.size()
      unsavedInsureds[InsuredType.CHILD] = []
      unsavedChildsNumber.times{ i ->
        unsavedInsureds[InsuredType.CHILD] << new Insured()
      }
    }

    unsavedInsureds
  }

}
