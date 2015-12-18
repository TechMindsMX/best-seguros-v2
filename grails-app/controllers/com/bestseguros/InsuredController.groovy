package com.bestseguros

class InsuredController {

  def insuredService
  def policyService

  def save(Insured insured){
    def policy = Policy.get(params.long("policy"))

    if(insured.hasErrors()){
      def insureds = policyService.findSavedAndUnsavedInsuredsForPolicy(policy)
      def insuredTypes = policy?.plan?.insureds*.insured.unique() ?: []
      def model = [policy:policy,insuredTypes:insuredTypes.sort()]

      if(insured.insuredType != InsuredType.CONTRACTING_PARTY){
        insureds.unsavedInsureds[insured.insuredType].remove(0)
        insureds.unsavedInsureds[insured.insuredType].add(0,insured)
      }
      else{
        model.contractingParty = policyService.getContractingParty(policy) ?: insured
        model.principal = params.boolean("principal")
      }

      model.insureds = insureds

      render view:"/policy/edit",model:model
      return
    }

    if(params.boolean("principal")){
      insuredService.addContratingPartyAndPrincipalForPolicy(insured,policy)
    }
    else
      insuredService.addInsuredForPolicy(insured,policy)

    redirect(controller:"policy",action:"edit",id:policy.id)
  }

}
