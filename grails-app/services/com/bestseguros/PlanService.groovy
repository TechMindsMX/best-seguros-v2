package com.bestseguros

import grails.transaction.Transactional

@Transactional
class PlanService {
  
  def findPlansForProduct(Long productId){
    Product.get(productId).plans
  }

}
