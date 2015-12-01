package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(PlanService)
@Mock([Plan,Product])
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
      def productPlans = service.findPlansForProduct(products.first().id)
    then:
      productPlans.size() == 2 
  }

}
