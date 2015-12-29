package com.bestseguros.bean

import com.bestseguros.Policy
import org.apache.camel.Exchange
import org.apache.camel.processor.aggregate.AggregationStrategy

class PolicyAggregationStrategy implements AggregationStrategy{

  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    if(!oldExchange)
      return newExchange

    oldExchange
  }

}
