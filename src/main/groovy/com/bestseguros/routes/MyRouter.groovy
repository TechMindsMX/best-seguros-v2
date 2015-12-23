package com.bestseguros.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.Exchange

class MyRouter extends RouteBuilder{

  @Override
  void configure() throws Exception{
    from("file:///Users/makingdevs/Documents/SoftwareDevelopment/MakingDevs/filesToProcess?delete=true")
    //.filter { exchange -> exchange.in.headers.CamelFileName.endsWith("xls") }
    .filter { exchange -> exchange.in.headers.CamelFileName.endsWith("csv") }
    .split(body(String.class).tokenize(","))
    //.aggregate(header("CamelFileName"), new StringAggregationStrategy()).completionTimeout(3000)
    .to("log:groovymail?showAll=true&multiline=true")
    .to("file:///Users/makingdevs/Documents/SoftwareDevelopment/MakingDevs/exported")
  }

}
