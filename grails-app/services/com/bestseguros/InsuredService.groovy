package com.bestseguros

import grails.transaction.Transactional

@Transactional
class InsuredService {

  def addInsuredForPolicy(Insured insured,Policy policy){
    policy.addToInsureds(insured) 
    policy.save()
    policy
  }

}
