// Place your Spring DSL code here
import com.bestseguros.routes.FileRoute
import com.bestseguros.bean.SplitterBean

beans = {

  localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
    defaultLocale = new Locale("es","MX")
    java.util.Locale.setDefault(defaultLocale)
  }

  splitterBean(SplitterBean)

  myRouter(FileRoute){
    grailsApplication = ref('grailsApplication')
  }

}
