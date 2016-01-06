class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?(.$format)?"{
      constraints {
        // apply constraints here
      }
    }

    "/"(controller:"home")
    "500"(view:'/error')
    "404"(view:'/notFound')

    "/products"(resources:'product')
    "/plans"(resources:'plan')
    "/policies"(resources:'policy')
  }

}
