package com.bestseguros

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PolicyController {

  static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

  def index(Integer max) {
    params.max = Math.min(max ?: 10, 100)
    respond Policy.list(params), model:[policyCount: Policy.count()]
  }

  def show(Policy policy) {
    respond policy
  }

  def create() {
    [insurances:Insurance.list()]
  }

  @Transactional
  def save(Policy policy) {
    if(policy == null) {
      transactionStatus.setRollbackOnly()
      notFound()
      return
    }

    if(policy.hasErrors()) {
      transactionStatus.setRollbackOnly()
      respond policy.errors, view:'create'
      return
    }

    policy.save flush:true

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.created.message', args: [message(code: 'policy.label', default: 'Policy'), policy.id])
        redirect policy
      }
      '*' { respond policy, [status: CREATED] }
    }
  }

  def edit(Policy policy) {
    respond policy
  }

  @Transactional
  def update(Policy policy) {
    if (policy == null) {
      transactionStatus.setRollbackOnly()
      notFound()
      return
    }

    if (policy.hasErrors()) {
      transactionStatus.setRollbackOnly()
      respond policy.errors, view:'edit'
      return
    }

    policy.save flush:true

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.updated.message', args: [message(code: 'policy.label', default: 'Policy'), policy.id])
        redirect policy
      }
      '*'{ respond policy, [status: OK] }
    }
  }

  @Transactional
  def delete(Policy policy) {

    if (policy == null) {
      transactionStatus.setRollbackOnly()
      notFound()
      return
    }

    policy.delete flush:true

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'policy.label', default: 'Policy'), policy.id])
        redirect action:"index", method:"GET"
      }
      '*'{ render status: NO_CONTENT }
    }
  }

  protected void notFound() {
    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'policy.label', default: 'Policy'), params.id])
        redirect action: "index", method: "GET"
      }
      '*'{ render status: NOT_FOUND }
    }
  }
}
