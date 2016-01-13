package com.bestseguros

import grails.converters.JSON

class PaymentController {

  def index() {

  }

  def providers(){
    def cardProviders = CardProvider.values()

    withFormat{
      json{
        JSON.use('policy')
        render cardProviders as JSON
      }
    }
  }

}
