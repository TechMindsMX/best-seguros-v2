package com.bestseguros

import grails.transaction.Transactional

@Transactional
class ProductService {

  def findInsuranceProducts(Long insuranceId){
    Product.where{
      insurance.id == insuranceId
    }.list()
  }

}
