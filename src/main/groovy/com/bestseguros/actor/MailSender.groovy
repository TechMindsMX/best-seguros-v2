package com.bestseguros.actor

import groovyx.gpars.actor.DefaultActor

@Singleton
class MailSender extends DefaultActor{

  void act(){
    loop{
      react{ policyId ->
        println "PolicyID ${policyId}"
      }
    }
  }
}
