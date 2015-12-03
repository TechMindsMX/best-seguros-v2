package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.Coverage

class CoverageMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof Coverage
  }

  void marshalObject(Object object,JSON json){
    def coverage = object as Coverage
    def coverageValues = [name:coverage.name]

    json.convertAnother(coverageValues)
  }

}
