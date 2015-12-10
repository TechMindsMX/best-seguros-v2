package com.bestseguros

class InsuredController {

  def insuredService
  def policyService

  def save(Insured insured){
    def policy = Policy.get(params.long("policy"))

    if(insured.hasErrors()){
      def insureds = policyService.findSavedAndUnsavedInsuredsForPolicy(policy)
      def insuredTypes = policy?.plan?.insureds*.insured ?: []
      insureds.unsavedInsureds[insured.insuredType].remove(0)
      insureds.unsavedInsureds[insured.insuredType].add(0,insured)
      render view:"/policy/edit",model:[policy:policy,insuredTypes:insuredTypes.sort(),insureds:insureds]
      return
    }

    insuredService.addInsuredForPolicy(insured,policy)
    redirect(controller:"policy",action:"edit",id:policy.id)
  }

}
