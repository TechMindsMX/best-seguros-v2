package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.CardProvider

class CardProviderMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof CardProvider
  }

  void marshalObject(Object object,JSON json){
    def cardProvider = object as CardProvider
    def cardProviderValues = [id:cardProvider.key,
                              value:cardProvider.value]
    json.convertAnother(cardProviderValues)
  }

}
