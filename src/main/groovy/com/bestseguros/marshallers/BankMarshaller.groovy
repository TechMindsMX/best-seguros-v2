package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.Bank

class BankMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof Bank
  }

  void marshalObject(Object object,JSON json){
    def bank = object as Bank
    def bankValues = [name:bank.name]

    json.convertAnother(bankValues)
  }
}
