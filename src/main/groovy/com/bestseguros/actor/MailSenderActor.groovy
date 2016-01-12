package com.bestseguros.actor

import groovyx.gpars.actor.DefaultActor

class MailSenderActor extends DefaultActor{
  
  def notificationService

  void act(){
    loop{
      react{ policyId ->
        notificationService.sendPolicyPDF(policyId) 
      }
    }
  }

}
