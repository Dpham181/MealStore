package newstore

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/search"(controller: 'search', action: 'search')

        "/"(controller: 'meal', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
