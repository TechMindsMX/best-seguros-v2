package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.Insurance

class InsuranceMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof Insurance
  }

  void marshalObject(Object object,JSON json){
    def insurance = object as Insurance
    def insuranceValues = [id:insurance.id,
                           name:insurance.name]

    json.convertAnother(insuranceValues)
  }

}
