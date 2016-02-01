package com.bestseguros

class NotificationController {

  def notificationService

  def sendPolicyMail(Policy policy){
    notificationService.sendPolicyPDF(policy)
    flash.sent = "La póliza ha sido enviada"
    redirect(controller:"policy",action:"edit",id:policy.id)
  }
}
