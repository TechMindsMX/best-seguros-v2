package com.bestseguros

class InsuredController {

  def insuredService
  def policyService

  def save(Insured insured){
    insured.birthDate = new Date()
    insured.validate()
    def policy = Policy.get(params.long("policy"))

    if(insured.hasErrors()){
      def insureds = policyService.findSavedAndUnsavedInsuredsForPolicy(policy)
      def insuredTypes = policy?.plan?.insureds*.insured ?: []
      insureds.unsavedInsureds[insured.insuredType].first().properties = insured.properties
      render view:"/policy/edit",model:[policy:policy,insuredTypes:insuredTypes.sort(),insureds:insureds]
      return
    }
    
    insuredService.addInsuredForPolicy(insured,policy)  
    redirect(controller:"policy",action:"edit",id:policy.id) 
  }

}
