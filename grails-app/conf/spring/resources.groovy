// Place your Spring DSL code here
import com.bestseguros.routes.FileRoute
import com.bestseguros.bean.SplitterBean
import com.bestseguros.actor.MailSenderActor
import org.springframework.jms.config.SimpleJmsListenerContainerFactory
import org.springframework.jms.config.DefaultJmsListenerContainerFactory

beans = {

  localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
    defaultLocale = new Locale("es","MX")
    java.util.Locale.setDefault(defaultLocale)
  }

  splitterBean(SplitterBean)

  mailSenderActor(MailSenderActor){
    notificationService = ref('notificationService')
  }

  myRouter(FileRoute){
    grailsApplication = ref('grailsApplication')
  }

}
