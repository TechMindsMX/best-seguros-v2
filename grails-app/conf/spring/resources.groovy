// Place your Spring DSL code here
import com.bestseguros.routes.MyRouter

beans = {

  localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
    defaultLocale = new Locale("es","MX")
    java.util.Locale.setDefault(defaultLocale)
  }

  myRouter(MyRouter)

}
