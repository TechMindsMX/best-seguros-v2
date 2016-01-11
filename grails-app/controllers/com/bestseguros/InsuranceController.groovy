package com.bestseguros

import grails.converters.JSON

class InsuranceController {

  def index(){ 
    withFormat{
      json{
        JSON.use('policy')
        render Insurance.list() as JSON
      }
    }
  }

}
