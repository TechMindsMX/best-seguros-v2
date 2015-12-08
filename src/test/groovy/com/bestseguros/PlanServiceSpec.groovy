package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should
import com.bestseguros.InsuredForPlan

@TestFor(PlanService)
@Mock([Plan,Product,Coverage,Benefit,InsuredSumPerCoveragePerInsured,RangeAgeByBeneficiary,InsuredForPlan])
class PlanServiceSpec extends Specification {

  Should "get the plans of a product"(){
    given:"the products"
      def products = [new Product(name:"Renta diaria por Hospitalización"),
                      new Product(name:"Producto 2")]

    and:"the plans of each product"
      def plansForProduct = [[new Plan(name:"Titular"),
                              new Plan(name:"Titular y Cónyuge")],
                             [new Plan(name:"Titular")]]

      plansForProduct.eachWithIndex{ plans, i ->
        plans.each{ plan ->
          products[i].addToPlans(plan)
        }
      }

      products*.save(validate:false)

    when:
      def productPlans = service.findPlansForProduct(products.first().uuid)
    then:
      productPlans.size() == 2
  }

  Should "get the info of a product"(){
    given:"the plan "
      def coverages = [new Coverage(name:"First Coverage"),new Coverage(name:"Second Coverage")]
      coverages*.save(validate:false)

      def product = new Product(name:"A product",
                                rangesAgeByBeneficiary:[new RangeAgeByBeneficiary(insuredType:InsuredType.PRINCIPAL,
                                                                                  minAge:18,
                                                                                  maxAge:57,
                                                                                  renewal:63).save(validate:false)],
                                insuranceCostsPerInsured:[new InsuranceCostPerInsured(insuranceCost:800,
                                                                                      insured:InsuredType.PRINCIPAL)])
      def insuredSums = [new InsuredSumPerCoveragePerInsured(coverage:coverages[0],
                                                             insuredSum:750,
                                                             insured:InsuredType.PRINCIPAL),
                         new InsuredSumPerCoveragePerInsured(coverage:coverages[1],
                                                             insuredSum:750,
                                                             insured:InsuredType.PRINCIPAL)]
      def plan = new Plan(name:"Titular",
                          coverages:coverages,
                          insureds:[new InsuredForPlan(insured:InsuredType.PRINCIPAL)],
                          benefits:[new Benefit(name:"Some Benefit").save(validate:false)])

      insuredSums.each{ insuredSum ->
        plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
      }

      product.addToPlans(plan)
      product.save(validate:false)

    when:
      def planInfo = service.getPlanDetail(plan)
    then:
      planInfo.insuredSumsByCoveragePerInsured[InsuredType.PRINCIPAL.value].size() == 2
      planInfo.rangeAgesByBeneficiary.size() == 1
      planInfo.insuranceCostsPerInsured.size() == 1
  }

}
