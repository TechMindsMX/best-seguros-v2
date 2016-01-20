package com.bestseguros

import grails.transaction.Transactional
import org.apache.camel.*
import com.bestseguros.actor.MailSenderActor

class MessageService {

  def mailSenderActor

  def sendPolicyMail(Exchange exchange){
    def policy = exchange.getIn().getBody(Policy.class)

    if(!mailSenderActor.isActive()){
      mailSenderActor.start()
    }

    mailSenderActor.send policy.id
  }

}
