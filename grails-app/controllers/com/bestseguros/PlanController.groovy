package com.bestseguros

import grails.converters.JSON

class PlanController {

  def planService

  def index(){ 
    withFormat{
      json{
        JSON.use('policy')
          render planService.findPlansForProduct(params.id) as JSON
      }
    }
  }

}
