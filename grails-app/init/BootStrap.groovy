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
import com.bestseguros.Benefit

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
    def coverages = Coverage.getAll(4..7)

    def prices = [[25000,25000,0],
                  [700,700,350],
                  [700,700,350],
                  [1400,1400,700]]

    def insuredSums = [:]

    coverages*.save()

    InsuredType.values().eachWithIndex{ insuredType, i ->
      def insuredSumsByCoverage = []
      coverages.eachWithIndex{ coverage, j ->
        insuredSumsByCoverage << new InsuredSumPerCoveragePerInsured(coverage:coverage,
                                                                     insuredSum:prices[j][i],
                                                                     insured:insuredType)
      }

      insuredSums[insuredType] = insuredSumsByCoverage
    }

    insuredSums
  }

  def createFirstProduct(){
    def coverages = Coverage.getAll(1..3)
    def product = new Product(name:"Renta diaria por Hospitalización",
                               trade:Trade.findByName("Accidentes personales"),
                               coin:"MXN",
                               country:"México",
                               insurance:Insurance.get(1),
                               sponsor:Sponsor.get(1),
                               periodicity:Periodicity.MONTHLY,
                               iva:false)

    def insuredSumsByCoverage = createInsuredSumsForFirstProduct()

    def productBenefits = [new Benefit(name:"Check up anual"),
                           new Benefit(name:"Check up anual(sólo titular)"),
                           new Benefit(name:"Check up anual(sólo titular y cónyuge)")]

    def plans = [new Plan(name:"Titular",
                          insureds:[InsuredType.PRINCIPAL],
                          benefits:[productBenefits[0]]),
                 new Plan(name:"Titular y Cónyuge",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE],
                          benefits:[productBenefits[0]]),
                 new Plan(name:"Titular e hijo(s)",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.CHILD],
                          benefits:[productBenefits[1]]),
                 new Plan(name:"Titular, Cónyuge e hijo(s)",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE,InsuredType.CHILD],
                          benefits:[productBenefits[2]])]

    plans.each{ plan ->
      plan.insureds.each{ insured ->
        insuredSumsByCoverage[insured].each{ insuredSum ->
          plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
        }
      }

      coverages.each{ coverage ->
        plan.addToCoverages(coverage)
      }

      product.addToPlans(plan)
    }

    product.save()
  }

  def createSecondProduct(){
    def coverages = Coverage.getAll(1..3)
    def product = new Product(name:"Renta diaria por Hospitalización",
                              trade:Trade.findByName("Vida"),
                              coin:"MXN",
                              country:"México",
                              insurance:Insurance.get(2),
                              sponsor:Sponsor.get(1),
                              periodicity:Periodicity.MONTHLY,
                              iva:false)

    def insuredSumsByCoverage = createInsuredSumsForSecondProduct()
    def productBenefits = [new Benefit(name:"Plan visual"),
                           new Benefit(name:"Plan dental")]

    def plans = [new Plan(name:"Titular",
                          insureds:[InsuredType.PRINCIPAL],
                          benefits:productBenefits),
                 new Plan(name:"Titular y Cónyuge",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE],
                          benefits:productBenefits),
                 new Plan(name:"Titular e hijos dependientes",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.CHILD],
                          benefits:productBenefits),
                 new Plan(name:"Titular, cónyuge e hijos dependientes",
                          insureds:[InsuredType.PRINCIPAL,InsuredType.SPOUSE,InsuredType.CHILD,InsuredType.CHILD],
                          benefits:productBenefits)]

    plans.each{ plan ->
      plan.insureds.each{ insured ->
        insuredSumsByCoverage[insured].each{ insuredSum ->
          plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
        }
      }

      coverages.each{ coverage ->
        plan.addToCoverages(coverage)
      }

      product.addToPlans(plan)
    }

    product.save()
  }

  def createProducts(){
    if(!Product.count()){
      createFirstProduct()
      createSecondProduct()
    }
  }

}
