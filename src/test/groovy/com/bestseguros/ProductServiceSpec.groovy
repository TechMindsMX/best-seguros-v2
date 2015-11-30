package com.bestseguros

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import java.lang.Void as Should

@TestFor(ProductService)
@Mock([Product,Insurance])
class ProductServiceSpec extends Specification{

  Should "get the products of an insurance"(){
    given:"the insurances"
      def insurances = [new Insurance(name:"Pan-American México"),
                        new Insurance(name:"Thona")]
      insurances*.save()
    and:"the products of an insurance"
      def products = [new Product(name:"Product1",insurance:insurances.first()),
                      new Product(name:"Product2",insurance:insurances.first())]
      products*.save(validate:false)
    when:
      def insuranceProducts = service.findInsuranceProducts(insurance_id)
    then:
      insuranceProducts.size() == products_size
    where:
      insurance_id | products_size
        1          | 2
        2          | 0
  }
}
