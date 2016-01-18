package com.bestseguros.bean

import com.bestseguros.Policy
import org.apache.camel.Exchange
import org.apache.camel.processor.aggregate.AggregationStrategy

class PolicyAggregationStrategy implements AggregationStrategy{

  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    def policies = null
    Policy newPolicy = newExchange.getIn().getBody(Policy.class)
    newPolicy.fileName = newExchange.in.headers.CamelFileName

    if(!oldExchange){
      policies = new ArrayList<Policy>()
      policies << newPolicy
      newExchange.in.setBody(policies)
      newExchange
    }
    else{
      policies = oldExchange.in.getBody(ArrayList.class);
      policies << newPolicy
      oldExchange
    }
  }

}
