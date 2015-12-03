package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.InsuranceCostPerInsured

class InsuranceCostPerInsuredMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof InsuranceCostPerInsured
  }

  void marshalObject(Object object,JSON json){
    def insuranceCostPerInsured = object as InsuranceCostPerInsured
    def insuranceCostPerInsuredValues = [insuranceCost:insuranceCostPerInsured.insuranceCost]
    json.convertAnother(insuranceCostPerInsuredValues)
  }

}
