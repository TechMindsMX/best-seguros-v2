package com.bestseguros

class PlanController {

  def planService

  def index(){ 
    def product = Product.findByUuid(params.id) 
    withFormat{
      json{
        JSON.use('policy')
          planService.findPlansForProduct(product.id)
      }
    }
  }

}
