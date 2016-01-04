package com.bestseguros.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.Exchange
import org.apache.camel.CamelContext
import org.apache.camel.spring.SpringCamelContext
import org.springframework.context.annotation.Configuration
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration
import com.bestseguros.bean.PolicyAggregationStrategy

@Configuration
class FileRoute extends SingleRouteCamelConfiguration{

  def grailsApplication

  @Override
  protected CamelContext createCamelContext(){
    new SpringCamelContext(getApplicationContext())
  }

  @Override
  public RouteBuilder route(){
    return new RouteBuilder(){
      void configure() throws Exception{
        //.to(grailsApplication.config.endPoint.to)
        //.to("mock:result")
        from(grailsApplication.config.endPoint.from)
        .filter { exchange ->
          exchange.in.headers.CamelFileName.endsWith("xlsx")
        }
        .split().method("splitterBean","splitBody")
        .aggregate(header("CamelFileName"), new PolicyAggregationStrategy()).completionTimeout(3000)
        .to("bean:policiesFileService?method=savePolicies(*)")
        .to("mock:result")

      }
    }
  }

}
