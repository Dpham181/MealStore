package MealStore

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED

class SearchController {
    SearchService s
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    // search functions

    def search (){
        session["meals"] = null
        String term = params.term ;
        s = new SearchService(term );
        def  meals = s.serviceMethod();
        if(meals.isEmpty()){
            redirect(view: "NotFound")

        }else {
            session["meals"] = meals
            redirect(action: "MealSearch")
        }
    }

    def MealSearch() {
        def meals =  session["meals"];
        session["meals"] = null

        render(view: "MealSearch", model: [Meals: meals])

    }


}
