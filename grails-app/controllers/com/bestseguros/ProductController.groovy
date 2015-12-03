package com.bestseguros

import grails.converters.JSON

class ProductController {

  def productService

  def index(Insurance insurance){
    withFormat{
      json{
        JSON.use('policy')
        render productService.findInsuranceProducts(insurance?.id ?: 0) as JSON
      }
    }
  }

}
