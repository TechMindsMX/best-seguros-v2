package com.bestseguros

import grails.transaction.Transactional
import org.springframework.jms.annotation.JmsListener
import org.apache.camel.*
import com.bestseguros.actor.MailSender

class MessageService {

  def mailSender

  def sendPolicyMail(Exchange exchange){
    def policy = exchange.getIn().getBody(Policy.class)

    if(!mailSender.isActive())
      mailSender.start()

    mailSender.send policy.id
  }

}
