package com.bestseguros.marshallers

import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller
import com.bestseguros.InsuredSumPerCoveragePerInsured

class InsuredSumPerCoveragePerInsuredMarshaller implements ObjectMarshaller<JSON>{

  boolean supports(Object object){
    object instanceof InsuredSumPerCoveragePerInsured
  }

  void marshalObject(Object object,JSON json){
    def insuredSumPerCoveragePerInsured = object as InsuredSumPerCoveragePerInsured
    def insuredSumPerCoveragePerInsuredValues = [coverage:insuredSumPerCoveragePerInsured.coverage,
                                                 insuredSum:insuredSumPerCoveragePerInsured.insuredSum,
                                                 insured:insuredSumPerCoveragePerInsured.insured.key]

    json.covertAnother(insuredSumPerCoveragePerInsuredValues)
  }
}
