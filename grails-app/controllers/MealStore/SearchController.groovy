package MealStore

class SearchController {
    SearchService s
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    // search functions

    def search (){
        String type = params.type;
        String term = params.term ;
        s = new SearchService(type,term );
        def  meals = s.serviceMethod();
        session["meals"] = meals
        redirect(action: "MealSearch")

    }

    def MealSearch() {
        def meals =  session["meals"];
        println(meals)
       render(view: "MealSearch", model: [Meals: meals])

    }
}
