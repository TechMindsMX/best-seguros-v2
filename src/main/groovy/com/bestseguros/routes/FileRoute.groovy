package com.bestseguros.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.Exchange
import org.apache.camel.CamelContext
import org.apache.camel.spring.SpringCamelContext
import org.springframework.context.annotation.Configuration
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration

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
        from(grailsApplication.config.endPoint.from)
        //.filter { exchange -> exchange.in.headers.CamelFileName.endsWith("xls") }
        .filter { exchange -> exchange.in.headers.CamelFileName.endsWith("xls") }
        //.split(body(String.class).tokenize(","))
        //.aggregate(header("CamelFileName"), new StringAggregationStrategy()).completionTimeout(3000)
        .to("log:groovymail?showAll=true&multiline=true")
        .to(grailsApplication.config.endPoint.to)
      }
    }
  }

}
