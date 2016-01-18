package com.bestseguros.bean

import com.bestseguros.Policy
import org.apache.camel.Exchange
import org.apache.camel.processor.aggregate.AggregationStrategy

class PolicyAggregationStrategy implements AggregationStrategy{

  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    def policies = null
    LinkedHashMap policyInfo = newExchange.getIn().getBody(LinkedHashMap.class)
    policyInfo.policy.fileName = newExchange.in.headers.CamelFileName

    if(!oldExchange){
      policies = []
      policies << policyInfo
      newExchange.in.setBody(policies)
      newExchange
    }
    else{
      policies = oldExchange.in.getBody(ArrayList.class);
      policies << policyInfo
      oldExchange
    }
  }

}
