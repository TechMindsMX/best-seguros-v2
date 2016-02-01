package com.bestseguros

import grails.transaction.Transactional

@Transactional
class NotificationService {

  def mailService
  def pdfRenderingService
  def policyService
  def grailsApplication

  def sendPolicyPDF(Policy policy){
    def policyDetail = policyService.getPolicyDetail(policy.id)
    def email = policyDetail.contractingParty.email

    ByteArrayOutputStream bytes = pdfRenderingService.render(template:"/pdfs/report",model:[policyDetail:policyDetail])

    mailService.sendMail{
      multipart true
      to email
      from grailsApplication.config.mail.from
      subject "Póliza BestSeguros"
      body "Póliza de seguros"
      attachBytes "Policy.pdf","application/pdf",bytes.toByteArray()
    }
  }

  def sendPolicyError(Policy policy,Boolean invalidProduct=false){
    mailService.sendMail{
      to grailsApplication.config.mail.error.to
      from grailsApplication.config.mail.from
      subject "Error"
      body(view:"/notification/error",
           plugin:"email-confirmation",
           model:[insureds:policy?.insureds,invalidProduct:invalidProduct])
    }
  }

}
