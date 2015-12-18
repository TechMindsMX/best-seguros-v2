package com.bestseguros

import grails.transaction.Transactional
import org.grails.core.DefaultGrailsDomainClass

@Transactional
class InsuredService {

  def addInsuredForPolicy(Insured insured,Policy policy){
    policy.addToInsureds(insured)
    policy.save()
    policy
  }

  def addContratingPartyAndPrincipalForPolicy(Insured insured,Policy policy){
    def domainClass = new DefaultGrailsDomainClass(Insured.class)
    def fields = domainClass.persistentProperties*.name.grep{
                   !['insuredType','dateCreated','lastUpdated'].contains(it)
                 }

    def principal = new Insured(insuredType:InsuredType.PRINCIPAL)

    fields.each{ field ->
      principal[field] = insured[field]
    }

    addInsuredForPolicy(principal,policy)
    addInsuredForPolicy(insured,policy)
  }

}
