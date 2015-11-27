import com.bestseguros.Insurance
import com.bestseguros.Coverage
import com.bestseguros.Sponsor
import com.bestseguros.Bank
import com.bestseguros.Trade
import com.bestseguros.Plan
import com.bestseguros.InsuredSumPerCoveragePerInsured
import com.bestseguros.InsuredType

class BootStrap {

  def init = { servletContext ->
    createInsurances()
    createSponsors()
    createCoverages()
    createBanks()
    createTrades()
    createInsuredSumsPerCoveragePerInsured()
  }

  def destroy = {

  }

  def createInsurances(){
    if(!Insurance.count()){
      def insurances = [new Insurance(name:"Pan-American México, Companía de Seguros"),
                        new Insurance(name:"Thona")]

      insurances.each{ insurance ->
        insurance.save(failOnError:true)
      }
    }
  }

  def createSponsors(){
    if(!Sponsor.count()){
      def sponsor = new Sponsor(name:"Default Sponsor")
      sponsor.save()
    }
  }

  def createCoverages(){
    if(!Coverage.count()){
      def coverages = [new Coverage(name:"Hospitalización por enfermedad"),
                       new Coverage(name:"Hospitalización por Embarazo (Hasta 10 días, sólo a la mujer)"),
                       new Coverage(name:"Hospitalización por Accidente")]

      coverages*.save()
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

  def createInsuredSumsPerCoveragePerInsured(){
    if(!InsuredSumPerCoveragePerInsured.count()){
      InsuredType.values().each{ insuredType ->
        [new InsuredSumPerCoveragePerInsured(coverage:Coverage.get(1),
                                             insuredSum:700,
                                             insured:insuredType),
         new InsuredSumPerCoveragePerInsured(coverage:Coverage.get(2),
                                             insuredSum:700,
                                             insured:insuredType),
         new InsuredSumPerCoveragePerInsured(coverage:Coverage.get(3),
                                             insuredSum:1400,
                                             insured:insuredType)]*.save()
      }
    }
  }

}
