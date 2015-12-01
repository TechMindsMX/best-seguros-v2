package com.bestseguros.marshallers

import com.bestseguros.Product
import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

class ProductMarshaller implements ObjectMarshaller{

  boolean supports(Object object){
    object instanceof Product
  }
  
  void marshalObject(object,json){
    def product = object as Product
    def productValues = [id:product.uuid,
                         name:product.name]

    json.convertAnother(productValues)
  }

}
