package com.bestseguros

import grails.converters.JSON

class ProductController {
  
  def productService

  def index(Insurance insurance){ 
    withFormat{
      json{ render productService.findInsuranceProducts(insurance.id) as JSON}
    }
  }
 
}
