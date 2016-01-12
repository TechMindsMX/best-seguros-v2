package com.bestseguros.marshallers

import grails.converters.JSON
import com.bestseguros.CardProvider

class CardProviderMarshaller{
  
  void register(){
    JSON.registerObjectMarshaller(CardProvider){ CardProvider cardProvider ->
      [key:cardProvider.key,
        value:cardProvider.value]
    }
  }

}
