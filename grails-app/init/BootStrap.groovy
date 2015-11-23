import com.bestseguros.Insurance

class BootStrap {

  def init = { servletContext ->
    createInsurances()
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

}
