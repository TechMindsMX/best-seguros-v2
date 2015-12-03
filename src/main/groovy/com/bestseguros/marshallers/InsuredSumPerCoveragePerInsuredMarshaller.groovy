package com.bestseguros.marshallers

import com.bestseguros.InsuredSumPerCoveragePerInsured
import grails.converters.JSON
import org.grails.web.converters.marshaller.ObjectMarshaller


class InsuredSumPerCoveragePerInsured{

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
