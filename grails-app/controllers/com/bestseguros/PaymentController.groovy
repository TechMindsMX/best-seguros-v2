package com.bestseguros

import grails.converters.JSON

class PaymentController {

  def index() { 

  }

  def providers(){
    withFormat{
      json{
        render CardProvider.values() as JSON
      }
    }    
  }

}
