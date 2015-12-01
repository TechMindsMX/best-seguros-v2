package com.bestseguros.marshallers

import com.bestseguros.Product
import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller

class ProductMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof Product
  }
  
  void marshalObject(Object object,JSON json){
    def product = object as Product
    def productValues = [id:product.uuid,
                         name:product.name]

    json.convertAnother(productValues)
  }

}
