package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PolicyService {

  def createPolicy(){
    def policy = new Policy(policyStatus:PolicyStatus.CREATED).save()
    policy
  }
}
