package com.bestseguros.actor

import groovyx.gpars.actor.DefaultActor
import org.springframework.stereotype.Component

@Component
class MailSender extends DefaultActor{

  void act(){
    loop{
      react{ policyId ->
        println "PolicyID ${policyId}"
      }
    }
  }

}
