// Place your Spring DSL code here
import com.bestseguros.routes.FileRoute
import com.bestseguros.bean.SplitterBean
import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.config.SimpleJmsListenerContainerFactory

beans = {

  localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
    defaultLocale = new Locale("es","MX")
    java.util.Locale.setDefault(defaultLocale)
  }

  splitterBean(SplitterBean)

  myRouter(FileRoute){
    grailsApplication = ref('grailsApplication')
  }

  jmsConnectionFactory(ActiveMQConnectionFactory) {
    brokerURL = "tcp://localhost:61616"
  }

  jmsListenerContainerFactory(SimpleJmsListenerContainerFactory){
    connectionFactory = ref('jmsConnectionFactory')
  }

}
