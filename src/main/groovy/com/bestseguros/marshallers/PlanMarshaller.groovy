package com.bestseguros.marshallers

import com.bestseguros.Plan
import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller

class PlanMarshaller implements ObjectMarshaller<JSON>{
  
  boolean supports(Object object){
    object instanceof Plan
  }

  void marshalObject(Object object,JSON json){
    def plan = object as Plan
    def planValues = [id:plan.id,
                      name:plan.name]

    json.convertAnother(planValues)
  }
}
