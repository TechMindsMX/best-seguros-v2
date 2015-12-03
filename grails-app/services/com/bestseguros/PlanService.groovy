package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PlanService {

  def findPlansForProduct(String uuid){
    Product.findByUuid(uuid).plans
  }

  def getPlanDetail(Plan plan){
    def product = plan.product
    def insuredSumsByCoveragePerInsured = [:]

    plan.insureds.each{ insured ->
      insuredSumsByCoveragePerInsured[insured] = plan.insuredSumsByCoveragePerInsured.findAll{ it.insured == insured }
    }

    [insuredSumsByCoveragePerInsured:insuredSumsByCoveragePerInsured,
     rangeAgesByBeneficiary:product.rangesAgeByBeneficiary,
     insuranceCostsPerInsured:product.insuranceCostsPerInsured]
  }
}
