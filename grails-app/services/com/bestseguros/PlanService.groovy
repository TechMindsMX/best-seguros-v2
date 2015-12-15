package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PlanService {

  def findPlansForProduct(String uuid){
    Product.findByUuid(uuid)?.plans?.sort{ plan -> plan.name } ?: []
  }

  def getPlanDetail(Plan plan){
    def product = plan.product
    def insuredSumsByCoveragePerInsured = [:]

    plan.insureds*.insured.sort().each{ insured ->
      insuredSumsByCoveragePerInsured[insured.value] = plan.insuredSumsByCoveragePerInsured.findAll{ it.insured == insured }.sort{ it.insured }
    }

    [product:product.id,
     plan:plan.id,
     insuredSumsByCoveragePerInsured:insuredSumsByCoveragePerInsured,
     rangeAgesByBeneficiary:product.rangesAgeByBeneficiary,
     insuranceCostsPerInsured:product.insuranceCostsPerInsured]
  }
}
