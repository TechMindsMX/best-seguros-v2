package com.bestseguros

import grails.transaction.Transactional

@Transactional
class NotificationService {

  def mailService
  def pdfRenderingService
  def policyService

  def sendPolicyPDF(Long policyId){
    def policy = Policy.get(policyId)
    def policyDetail = policyService.getPolicyDetail(policy)
    def email = policyDetail.contractingParty.email

    ByteArrayOutputStream bytes = pdfRenderingService.render(template:"/pdfs/report",model:[policyDetail:policyDetail])

    mailService.sendMail{
      multipart true
      to email
      from "egjimenezg@gmail.com"
      subject "Póliza BestSeguros"
      body 'Póliza de seguros'
      attachBytes "Policy.pdf","application/pdf",bytes.toByteArray()
    }
  }

}
