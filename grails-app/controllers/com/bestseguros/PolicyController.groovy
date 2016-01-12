package com.bestseguros

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

@Transactional
class PolicyController {

  def policyService

  static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

  def index() {
    def policies = policyService.findProductPolicies(params.product)

    withFormat{
      json{
        JSON.use('policy')
        render policies as JSON
      }
    }
  }

  def show(Policy policy) {
    def policyDetail = policyService.getPolicyDetail(policy)
    renderPdf(template:"/pdfs/report",model:[policyDetail:policyDetail])
  }

  def create() {
    def policy = policyService.createPolicy()
    redirect(action:"edit",id:policy.id)
  }

  def list(){ }

  def paymentMethod(Policy policy){
    if(!policyService.isThePolicyValid(policy)){
      redirect(action:"edit",id:policy.id)
      flash.message = "Falta capturar información para la póliza"
      return
    }

  }

  def edit(Policy policy) {
    def model = [policy:policy,
                 sepomexUrl:grailsApplication.config.sepomex.url,
                 contractingParty:policyService.getContractingParty(policy) ?: new Insured(insuredType:InsuredType.CONTRACTING_PARTY)]

    if(!policy.product)
      model.products = Product.list()
    else{
      def insureds = policyService.findSavedAndUnsavedInsuredsForPolicy(policy)
      def insuredTypes = policy?.plan?.insureds*.insured.unique() ?: []
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
      redirect(controller:"policy",action:"show",id:policy.id)
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
