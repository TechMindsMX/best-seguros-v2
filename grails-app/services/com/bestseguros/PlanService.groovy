package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PlanService {
  
  def findPlansForProduct(String uuid){
    Product.findByUuid(uuid).plans
  }

}
