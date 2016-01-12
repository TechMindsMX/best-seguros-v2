package com.bestseguros.actor

import groovyx.gpars.actor.DefaultActor

class MailSenderActor extends DefaultActor{

  void act(){
    loop{
      react{ policyId ->
        println "PolicyID ${policyId}"
      }
    }
  }

}
