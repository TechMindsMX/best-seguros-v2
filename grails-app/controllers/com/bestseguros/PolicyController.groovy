package com.bestseguros

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional
class PolicyController {

  def policyService
  static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

  def index(Integer max) {
    params.max = Math.min(max ?: 10, 100)
    respond Policy.list(params), model:[policyCount: Policy.count()]
  }

  def show(Policy policy) {
    respond policy
  }

  def create() {
    def policy = policyService.createPolicy()
    redirect(action:"edit",id:policy.id)
  }

  def edit(Policy policy) {
    def model = [:]
    model.policy = policy

    if(!policy.product)
      model.products = Product.list()
    else{
      def insureds = policyService.findSavedAndUnsavedInsuredsForPolicy(policy)
      def insuredTypes = policy?.plan?.insureds*.insured ?: []
      model << [insuredTypes:insuredTypes.sort(),insureds:insureds]
    }

    render view:"/policy/edit",model:model
  }

  def addProduct(Policy policy){
    policyService.addProductAndPlanToPolicy(policy.id,[product:params.long("product"),plan:params.long("plan")])
    redirect(action:"edit",id:policy.id)
  }

  @Transactional
  def save(Policy policy){
    if(!policyService.isThePolicyValid(policy)){
      redirect(action:"edit",id:policy.id)
      flash.message = "Falta capturar información para la póliza"
      return
    }
    else{
      policyService.updatePolicyStatus(policy)
      def policyDetail = policyService.getPolicyDetail(policy)
      renderPdf(template:"/pdfs/report",model:[policyDetail:policyDetail])
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
