import com.bestseguros.Insurance
import com.bestseguros.Coverage
import com.bestseguros.Sponsor
import com.bestseguros.Bank
import com.bestseguros.Trade
import com.bestseguros.Plan
import com.bestseguros.InsuredSumPerCoveragePerInsured
import com.bestseguros.InsuredType
import com.bestseguros.Product
import com.bestseguros.Periodicity

class BootStrap {

  def init = { servletContext ->
    createInsurances()
    createSponsors()
    createBanks()
    createTrades()
    createCoverages()
    createProducts()
  }

  def destroy = {

  }

  def createInsurances(){
    if(!Insurance.count()){
      def insurances = [new Insurance(name:"Pan-American México, Companía de Seguros"),
                        new Insurance(name:"Thona")]

      insurances.each{ insurance ->
        insurance.save()
      }
    }
  }

  def createSponsors(){
    if(!Sponsor.count()){
      def sponsor = new Sponsor(name:"Default Sponsor")
      sponsor.save()
    }
  }

  def createBanks(){
    if(!Bank.count()){
      def banks = [new Bank(name:"Bancomer"),
                   new Bank(name:"Santander")]
      banks*.save()
    }
  }

  def createTrades(){
    if(!Trade.count()){
      def trades = [new Trade(name:"Vida"),
                    new Trade(name:"Accidentes personales"),
                    new Trade(name:"Salud")]
      trades*.save()
    }
  }

  def createCoverages(){
    if(!Coverage.count()){
      def coverages = [new Coverage(name:"Hospitalización por enfermedad"),
                       new Coverage(name:"Hospitalización por Embarazo (Hasta 10 días, sólo a la mujer)"),
                       new Coverage(name:"Hospitalización por Accidente"),
                       new Coverage(name:"Básica por Fallecimiento"),
                       new Coverage(name:"Hospitalización por Enfermedad (Hasta 180 dias)"),
                       new Coverage(name:"Hospitalización por Embarazo (Hasta 10 días,sólo a la mujer)"),
                       new Coverage(name:"Hospitalización por Accidente (Hasta 360 días)")]

      coverages*.save()
    }
  }

  def createInsuredSumsForFirstProduct(){
    def coverages = Coverage.getAll(1..3)
    def prices = [700,700,1400]
    def insuredSums = [:]

    coverages*.save()

    InsuredType.values().each{ insuredType ->
      def insuredSumsByCoverage = []
      coverages.eachWithIndex{ coverage, i ->
        insuredSumsByCoverage << new InsuredSumPerCoveragePerInsured(coverage:coverage,
                                                           insuredSum:prices[i],
                                                           insured:insuredType)
      }
      insuredSumsByCoverage*.save()
      insuredSums[insuredType] = insuredSumsByCoverage
    }

    insuredSums
  }

  def createInsuredSumsForSecondProduct(){
    def coverages = [new Coverage(name:"Básica por Fallecimiento"),
                     new Coverage(name:"Hospitalización por Enfermedad (Hasta 180 dias)"),
                     new Coverage(name:"Hospitalización por Embarazo (Hasta 10 días,sólo a la mujer)"),
                     new Coverage(name:"Hospitalización por Accidente (Hasta 360 días)")]

    def prices = [[25000,25000,0],
                  [700,700,350],
                  [700,700,350],
                  [1400,1400,700]]

    def insuredSums = []
    coverages*.save()

    coverages.eachWithIndex{ coverage, i ->
      InsuredType.values().eachWithIndex{ insuredType, j ->
        insuredSums << new InsuredSumPerCoveragePerInsured(coverage:coverage,
                                                           insuredSum:prices[i][j],
                                                           insured:insuredType)
      }
    }

    insuredSums
  }

  def createFirstProduct(){
    def coverages = Coverage.getAll(1..3)
    def products = new Product(name:"Renta diaria por Hospitalización",
                               trade:Trade.findByName("Accidentes personales"),
                               coin:"MXN",
                               country:"México",
                               insurance:Insurance.get(1),
                               sponsor:Sponsor.get(1),
                               periodicity:Periodicity.MONTHLY,
                               iva:false)

    def insuredSumsByCoverage = createInsuredSumsForFirstProduct()


    def plans = [new Plan(name:"Titular",insureds:[InsuredType.PRINCIPAL]),
                 new Plan(name:"Titular y Cónyuge",insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE]),
                 new Plan(name:"Titular e hijo(s)",insureds:[InsuredType.PRINCIPAL,InsuredType.CHILD]),
                 new Plan(name:"Titular, Cónyuge e hijo(s)",insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE,InsuredType.CHILD])]

    plans.each{ plan ->
      plan.insureds.each{ insured ->
        insuredSumsByCoverage[insured].each{ insuredSum ->
          plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
        }
      }

      coverages.each{ coverage ->
        plan.addToCoverages(coverage)
      }

      plan.save()
    }
  }


  def createProducts(){
    if(!Product.count()){
      createFirstProduct()
    }
  }

}
