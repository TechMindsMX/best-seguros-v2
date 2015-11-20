package best_seguros_v2

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.core.env.MapPropertySource

class Application extends GrailsAutoConfiguration implements EnvironmentAware{
  static void main(String[] args) {
    GrailsApp.run(Application, args)
  }

  @Override
  void setEnvironment(Environment environment){
    def configFile= new File("${System.getProperty('user.home')}/.best_seguros/application-${environment.activeProfiles.first()}.groovy") 
    
    if(configFile.exists()){
      def config = new ConfigSlurper().parse(configFile.toURL())
      environment.propertySources.addFirst(new MapPropertySource("externalGroovyConfig",config)) 
    }
    else{
      println "External configuration not available"
    } 

  } 
}
