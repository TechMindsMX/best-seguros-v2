package com.bestseguros.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.Exchange
import org.apache.camel.CamelContext
import org.apache.camel.spring.SpringCamelContext
import org.apache.camel.dropbox.*
import org.springframework.context.annotation.Configuration
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration
import com.bestseguros.bean.PolicyAggregationStrategy
import org.springframework.jms.annotation.EnableJms

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
        from(grailsApplication.config.endPoint.from).filter{ exchange ->
          exchange.in.headers.DOWNLOADED_FILE.endsWith("xlsx")
        }
        .setHeader("CamelFileName",header("DOWNLOADED_FILE"))
        .to("${grailsApplication.config.endPoint.toFile}")
        .multicast().to("direct:moveFile","direct:processFile")

        from("direct:moveFile").to(grailsApplication.config.endPoint.to)

        from("direct:processFile").filter { exchange ->
          exchange.in.headers.CamelFileName.endsWith("xlsx")
        }
        .split().method("splitterService","splitBody")
        .aggregate(header("CamelFileName"), new PolicyAggregationStrategy()).completionTimeout(3000)
        .to("bean:policiesFileService?method=savePolicies(*)")
        .to("bean:policiesFileService?method=savePaymentMethod(*)")
        .to("bean:policiesFileService?method=removeInvalidPolicies(*)")
        .split(body())
        .to("bean:messageService?method=sendPolicyMail(*)")
      }
    }
  }

}
