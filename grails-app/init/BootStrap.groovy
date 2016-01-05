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
import com.bestseguros.InsuranceCostPerInsured
import com.bestseguros.RangeAgeByBeneficiary
import com.bestseguros.InsuredForPlan
import com.bestseguros.marshallers.*
import grails.converters.JSON

class BootStrap {

  def init = { servletContext ->
    createInsurances()
    createSponsors()
    createBanks()
    createTrades()
    createCoverages()
    createProducts()
    JSON.createNamedConfig('policy'){
      it.registerObjectMarshaller(new ProductMarshaller())
      it.registerObjectMarshaller(new PlanMarshaller())
      it.registerObjectMarshaller(new InsuredSumPerCoveragePerInsuredMarshaller())
      it.registerObjectMarshaller(new CoverageMarshaller())
      it.registerObjectMarshaller(new RangeAgeByBeneficiaryMarshaller())
      it.registerObjectMarshaller(new InsuranceCostPerInsuredMarshaller())
      it.registerObjectMarshaller(new InsuranceMarshaller())
    }
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
      [new Bank(name:"BANXICO"),
       new Bank(name:"BANCOMEXT"),
       new Bank(name:"BANOBRAS"),
       new Bank(name:"BANJERCITO"),
       new Bank(name:"NAFIN"),
       new Bank(name:"BANSEFI"),
       new Bank(name:"HIPOTECARIA FED"),
       new Bank(name:"BANAMEX"),
       new Bank(name:"BBVA BANCOMER"),
       new Bank(name:"SANTANDER"),
       new Bank(name:"HSBC"),
       new Bank(name:"BAJIO"),
       new Bank(name:"IXE"),
       new Bank(name:"INBURSA"),
       new Bank(name:"INTERACCIONES"),
       new Bank(name:"MIFEL"),
       new Bank(name:"SCOTIABANK"),
       new Bank(name:"BANREGIO"),
       new Bank(name:"INVEX"),
       new Bank(name:"BANSI"),
       new Bank(name:"AFIRME"),
       new Bank(name:"BANORTE"),
       new Bank(name:"INVESTA BANK"),
       new Bank(name:"AMERICAN EXPRES"),
       new Bank(name:"BAMSA"),
       new Bank(name:"TOKYO"),
       new Bank(name:"JP MORGAN"),
       new Bank(name:"BMONEX"),
       new Bank(name:"VE POR MAS"),
       new Bank(name:"DEUTSCHE"),
       new Bank(name:"CREDIT SUISSE"),
       new Bank(name:"AZTECA"),
       new Bank(name:"AUTOFIN"),
       new Bank(name:"BARCLAYS"),
       new Bank(name:"COMPARTAMOS"),
       new Bank(name:"BANCO FAMSA"),
       new Bank(name:"BMULTIVA"),
       new Bank(name:"ACTINVER"),
       new Bank(name:"WAL-MART"),
       new Bank(name:"INTERBANCO"),
       new Bank(name:"BANCOPPEL"),
       new Bank(name:"ABC CAPITAL"),
       new Bank(name:"UBS BANK"),
       new Bank(name:"CONSUBANCO"),
       new Bank(name:"VOLKSWAGEN"),
       new Bank(name:"CIBANCO"),
       new Bank(name:"BBASE"),
       new Bank(name:"BICENTENARIO"),
       new Bank(name:"AGROFINANZAS"),
       new Bank(name:"PAGATODO"),
       new Bank(name:"INMOBILIARIO"),
       new Bank(name:"DONDE"),
       new Bank(name:"BANCREA"),
       new Bank(name:"MONEXCB"),
       new Bank(name:"GBM"),
       new Bank(name:"MASARI"),
       new Bank(name:"VALUE"),
       new Bank(name:"ESTRUCTURADORES"),
       new Bank(name:"TIBER"),
       new Bank(name:"VECTOR"),
       new Bank(name:"B&B"),
       new Bank(name:"ACCIVAL"),
       new Bank(name:"MERRILL LYNCH"),
       new Bank(name:"FINAMEX"),
       new Bank(name:"VALMEX"),
       new Bank(name:"UNICA"),
       new Bank(name:"MAPFRE"),
       new Bank(name:"PROFUTURO"),
       new Bank(name:"CB ACTINVER"),
       new Bank(name:"OACTIN"),
       new Bank(name:"SKANDIA"),
       new Bank(name:"CBDEUTSCHE"),
       new Bank(name:"ZURICH"),
       new Bank(name:"ZURICHVI"),
       new Bank(name:"CB INTERCAM"),
       new Bank(name:"CI BOLSA"),
       new Bank(name:"FINCOMUN"),
       new Bank(name:"HDI SEGUROS"),
       new Bank(name:"ORDER"),
       new Bank(name:"AKALA"),
       new Bank(name:"CB JPMORGAN"),
       new Bank(name:"REFORMA"),
       new Bank(name:"STP"),
       new Bank(name:"TELECOMM"),
       new Bank(name:"EVERCORE"),
       new Bank(name:"OSKNDIA"),
       new Bank(name:"SEGMTY"),
       new Bank(name:"ASEA"),
       new Bank(name:"KUSPIT"),
       new Bank(name:"SOFIEXPRESS"),
       new Bank(name:"UNAGRA"),
       new Bank(name:"ASP INTEGRA OPC"),
       new Bank(name:"LIBERTAD"),
       new Bank(name:"HUASTECAS"),
       new Bank(name:"GNP"),
       new Bank(name:"AXA"),
       new Bank(name:"FICREA"),
       new Bank(name:"CAJA POP MEXICA"),
       new Bank(name:"SURA"),
       new Bank(name:"CLS"),
       new Bank(name:"INDEVAL")]*.save()
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

  def getInsuredsForPlan(){
    def insuredsForPlan = [[new InsuredForPlan(insured:InsuredType.PRINCIPAL)],
                           [new InsuredForPlan(insured:InsuredType.PRINCIPAL),new InsuredForPlan(insured:InsuredType.SPOUSE)],
                           [new InsuredForPlan(insured:InsuredType.PRINCIPAL)],
                           [new InsuredForPlan(insured:InsuredType.PRINCIPAL),new InsuredForPlan(insured:InsuredType.SPOUSE)]]

    15.times{
      insuredsForPlan[2] << new InsuredForPlan(insured:InsuredType.CHILD)
      insuredsForPlan[3] << new InsuredForPlan(insured:InsuredType.CHILD)
    }

    insuredsForPlan
  }

  def createFirstProduct(){
    def coverages = Coverage.getAll(1..3)

    def insuranceCosts = [new InsuranceCostPerInsured(insuranceCost:196.91,
                                                      insured:InsuredType.PRINCIPAL),
                          new InsuranceCostPerInsured(insuranceCost:150.51,
                                                      insured:InsuredType.SPOUSE),
                          new InsuranceCostPerInsured(insuranceCost:92.80,
                                                      insured:InsuredType.CHILD)]

    def rangesAgeByBeneficiary = [new RangeAgeByBeneficiary(insuredType:InsuredType.PRINCIPAL,
                                                            minAge:18,
                                                            maxAge:64,
                                                            renewal:69),
                                  new RangeAgeByBeneficiary(insuredType:InsuredType.SPOUSE,
                                                            minAge:18,
                                                            maxAge:64,
                                                            renewal:70),
                                  new RangeAgeByBeneficiary(insuredType:InsuredType.CHILD,
                                                            minAge:1,
                                                            maxAge:18,
                                                            renewal:21)]

    def product = new Product(name:"Renta diaria por Hospitalización - ${Insurance.get(1).name}",
                              trade:Trade.findByName("Accidentes personales"),
                              coin:"MXN",
                              country:"México",
                              insurance:Insurance.get(1),
                              sponsor:Sponsor.get(1),
                              iva:false)

    def insuredSumsByCoverage = createInsuredSumsForFirstProduct()

    def productBenefits = [new Benefit(name:"Check up anual"),
                           new Benefit(name:"Check up anual(sólo titular)"),
                           new Benefit(name:"Check up anual(sólo titular y cónyuge)")]

    def insuredsForPlan = getInsuredsForPlan()

    def plans = [new Plan(name:"Titular",
                          benefits:[productBenefits[0]]),
                 new Plan(name:"Titular y Cónyuge",
                          benefits:[productBenefits[0]]),
                 new Plan(name:"Titular e hijo(s)",
                          benefits:[productBenefits[1]]),
                 new Plan(name:"Titular, Cónyuge e hijo(s)",
                          benefits:[productBenefits[2]])]

    insuranceCosts.each{ insuranceCost ->
      product.addToInsuranceCostsPerInsured(insuranceCost)
    }

    rangesAgeByBeneficiary.each{ rangeAgeByBeneficiary ->
      product.addToRangesAgeByBeneficiary(rangeAgeByBeneficiary)
    }

    plans.eachWithIndex{ plan,i ->

      coverages.each{ coverage ->
        plan.addToCoverages(coverage)
      }

      insuredsForPlan[i].each{ insuredForPlan ->
        plan.addToInsureds(insuredForPlan)
      }

      plan.insureds*.insured.unique().each{ insured ->
        insuredSumsByCoverage[insured].each{ insuredSum ->
          plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
        }
      }

      product.addToPlans(plan)
    }

    product.save()
  }

  def createSecondProduct(){
    def coverages = Coverage.getAll(1..3)
    def insuranceCosts = [new InsuranceCostPerInsured(insuranceCost:195,
                                                      insured:InsuredType.PRINCIPAL),
                          new InsuranceCostPerInsured(insuranceCost:152.50,
                                                      insured:InsuredType.SPOUSE),
                          new InsuranceCostPerInsured(insuranceCost:85,
                                                      insured:InsuredType.CHILD)]

    def rangesAgeByBeneficiary = [new RangeAgeByBeneficiary(insuredType:InsuredType.PRINCIPAL,
                                                            minAge:18,
                                                            maxAge:64,
                                                            renewal:69),
                                  new RangeAgeByBeneficiary(insuredType:InsuredType.SPOUSE,
                                                            minAge:18,
                                                            maxAge:64,
                                                            renewal:69),
                                  new RangeAgeByBeneficiary(insuredType:InsuredType.CHILD,
                                                            minAge:1,
                                                            maxAge:18,
                                                            renewal:21)]


    def product = new Product(name:"Renta diaria por Hospitalización - ${Insurance.get(2).name}",
                              trade:Trade.findByName("Vida"),
                              coin:"MXN",
                              country:"México",
                              insurance:Insurance.get(2),
                              sponsor:Sponsor.get(1),
                              iva:false)

    def insuredSumsByCoverage = createInsuredSumsForSecondProduct()
    def productBenefits = [new Benefit(name:"Plan visual"),
                           new Benefit(name:"Plan dental")]

    def insuredsForPlan = getInsuredsForPlan()

    def plans = [new Plan(name:"Titular",
                          benefits:productBenefits),
                 new Plan(name:"Titular y Cónyuge",
                          benefits:productBenefits),
                 new Plan(name:"Titular e hijos dependientes",
                          benefits:productBenefits),
                 new Plan(name:"Titular, cónyuge e hijos dependientes",
                          benefits:productBenefits)]

    rangesAgeByBeneficiary.each{ range ->
      product.addToRangesAgeByBeneficiary(range)
    }

    insuranceCosts.each{ insuranceCost ->
      product.addToInsuranceCostsPerInsured(insuranceCost)
    }

    plans.eachWithIndex{ plan,i ->

      coverages.each{ coverage ->
        plan.addToCoverages(coverage)
      }

      insuredsForPlan[i].each{ insuredForPlan ->
        plan.addToInsureds(insuredForPlan)
      }

      plan.insureds*.insured.unique().each{ insured ->
        insuredSumsByCoverage[insured].each{ insuredSum ->
          plan.addToInsuredSumsByCoveragePerInsured(insuredSum)
        }
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
