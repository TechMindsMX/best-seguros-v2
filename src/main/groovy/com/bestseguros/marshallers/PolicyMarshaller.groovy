package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.Policy

class PolicyMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof Policy
  }

  void marshalObject(Object object,JSON json){
    def policy = object as Policy
    def policyValues = [uuid:policy.uuid,
                        id:policy.id,
                        product:policy.product,
                        plan:policy.plan,
                        status:policy.policyStatus.value]

    json.convertAnother(policyValues)
  }

}
