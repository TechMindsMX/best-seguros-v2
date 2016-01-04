package com.bestseguros.bean

import com.bestseguros.Policy
import org.apache.camel.Exchange
import org.apache.camel.processor.aggregate.AggregationStrategy

class PolicyAggregationStrategy implements AggregationStrategy{

  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    def policies = null
    Policy newPolicy = newExchange.getIn().getBody(Policy.class)

    if(!oldExchange){
      policies = new ArrayList<Policy>()
      policies << newPolicy
      newExchange.getIn().setBody(policies)
      newExchange
    }
    else{
      policies = oldExchange.getIn().getBody(ArrayList.class);
      policies << newPolicy
      oldExchange
    }
  }

}
