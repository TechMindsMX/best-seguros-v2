package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.RangeAgeByBeneficiary

class RangeAgeByBeneficiaryMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof RangeAgeByBeneficiary
  }

  void marshalObject(Object object,JSON json){
    def rangeAgeByBeneficiary = object as RangeAgeByBeneficiary
    def rangeValues = [insured:rangeAgeByBeneficiary.insuredType.value,
                       minAge:rangeAgeByBeneficiary.minAge,
                       maxAge:rangeAgeByBeneficiary.maxAge,
                       renewal:rangeAgeByBeneficiary.renewal]

    json.convertAnother(rangeValues)
  }

}
