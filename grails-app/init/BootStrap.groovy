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
      def insurances = [new Insurance(code:"0001",name:"Aseguradora 1",country:"México",fiscalAddress:"D.F.",phone:"5523697362",contact:"Eduardo Jiménez",rfc:"ASEG21022015"),
                      new Insurance(code:"0002",name:"Aseguradora 2",country:"México",fiscalAddress:"D.F.",phone:"5548109234",contact:"Gamaliel Jiménez",rfc:"ASEG21022016")]
      insurances.each{ insurance ->
        insurance.save(failOnError:true)
      } 
    }
  }

  def createSponsors(){
    if(!Sponsor.count()){
      def sponsor = [new Sponsor(code:"PALHIE",
                                 name:"Palacio de hierro",
                                 country:"México",
                                 fiscalAddress:"Av Paseo de la Reforma 3344",
                                 phone:"98765432",
                                 contact:"Lic José Luis Gonzalez Esponda",
                                 rfc:"PALA981221"),
                     new Sponsor(code:"LIVER1", 
                                 name:"LIVERPOOL",
                                 country:"México",
                                 fiscalAddress:"Av Paseo de la Reforma 1528",
                                 phone:"57658684",
                                 contact:"Second Sponsor",
                                 rfc:"JIGE930831")]
      sponsor*.save()  
    }
  }

  def createCoverages(){
    if(!Coverage.count()){
      def coverages = [new Coverage(code:"000012",
                                    name:"Beneficio de pago directo de Gastos Médicos por Accidente"),
                       new Coverage(code:"000112",
                                    name:"Check Up Médico Anual")]
      coverages*.save()
    }
  }

  def createBanks(){
    if(!Bank.count()){
      def banks = [new Bank(code:"002",name:"Banamex"),
                   new Bank(code:"106",name:"Bank of America")]
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
