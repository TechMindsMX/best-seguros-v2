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

  def findSavedAndUnsavedInsuredsForPolicy(Policy policy){
    def policyInsureds = policy.insureds ?: []
    def planInsureds = policy?.plan?.insureds ?: []

    def unsavedInsureds = [:]
    def savedInsureds = [:]

    planInsureds*.insured.unique().each{ insured ->
      def planInsuredsByType = planInsureds.findAll{ it.insured == insured }?.size() ?: 0
      def policyInsuredsByType = policyInsureds.findAll{ it.insuredType == insured }

      unsavedInsureds[insured] = []
      savedInsureds[insured] = []

      if(policyInsuredsByType?.size()){
        savedInsureds[insured] = policyInsuredsByType
      }

      (planInsuredsByType - (policyInsuredsByType?.size() ?: 0)).times{ i ->
        unsavedInsureds[insured] << new Insured(insuredType:insured)
      }
    }

    [unsavedInsureds:unsavedInsureds,savedInsureds:savedInsureds]
  }

  def isThePolicyValid(Policy policy){
    if(!policy.product)
      return false

    def plan = Plan.get(policy.plan.id)
    def policyInsureds = policy.insureds

    if(!policyInsureds.find{ it.insuredType == InsuredType.CONTRACTING_PARTY})
      return false

    def planInsureds = plan.insureds*.insured
    def insureds = plan.insureds*.insured.unique()

    def areTheInsuredsComplete = insureds.findAll{ it != InsuredType.CHILD}.every{ insured ->
      planInsureds.findAll{ it == insured }?.size() == policyInsureds.findAll{ it.insuredType == insured }?.size()
    }

    if(insureds.contains(InsuredType.CHILD))
      areTheInsuredsComplete && policyInsureds.findAll{ it.insuredType == InsuredType.CHILD }
    else
      areTheInsuredsComplete
  }

  def updatePolicyStatus(Policy policy){
    policy.policyStatus = PolicyStatus.FINISHED
  }

  def getPolicyDetail(Policy policy){
    def detail = [policyNumber:policy.id, dateCreated:policy.dateCreated]
    detail.contractingParty = policy.insureds.find{ it.insuredType == InsuredType.PRINCIPAL }
    detail.coin = policy.product.coin
    detail.productName = policy.product.name
    detail.benefits = policy.plan.insuredSumsByCoveragePerInsured.sort{ insuredSum -> insuredSum.insured }
    detail.insureds = policy.insureds.findAll{ insured -> insured.insuredType != InsuredType.CONTRACTING_PARTY }
    detail.monthlyInsuranceCost = 0

    detail.insureds.each{ insured ->
      detail.monthlyInsuranceCost += policy.product.insuranceCostsPerInsured.find{ it.insured == insured.insuredType }*.insuranceCost.sum()
    }

    detail
  }

  def getContractingParty(policy){
    policy.insureds.find{ it.insuredType == InsuredType.CONTRACTING_PARTY }
  }

  def findProductPolicies(String productUuid){
    def policies = Policy.findAll{
      product.uuid == productUuid
    }
  }

}
