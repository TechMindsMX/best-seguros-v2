import com.bestseguros.Insurance
import com.bestseguros.Coverage
import com.bestseguros.Sponsor
import com.bestseguros.Bank
import com.bestseguros.Trade

class BootStrap {

  def init = { servletContext ->
    createInsurances()
    createSponsors()
    createCoverages()
    createBanks()
    createTrades()
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
      def coverages = [new Coverage(name:"Beneficio de pago directo de Gastos Médicos por Accidente"),
                       new Coverage(name:"Check Up Médico Anual")]
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
                    new Trade(name:"Salud")]
      trades*.save()
    }
  }

}
