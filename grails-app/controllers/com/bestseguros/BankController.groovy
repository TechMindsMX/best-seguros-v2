package com.bestseguros

import grails.converters.JSON

class BankController {

  def index(){
    withFormat{
      json{
        JSON.use('policy')
        render Bank.list() as JSON
      }
    }
  }


}
