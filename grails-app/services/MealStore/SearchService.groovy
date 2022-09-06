package MealStore


import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.uri.UriBuilder
import io.micronaut.http.client.HttpClient
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject
import org.springframework.http.server.DelegatingServerHttpResponse

class SearchService {
     String UrlBase ="https://www.themealdb.com/" ;
     String search_term;


     SearchService(String search_term){
         this.search_term = search_term;
    };

   List<Meal> serviceMethod(){
       String term =""
       try {
           Integer.parseInt(this.search_term);
           term = "i"

       } catch (NumberFormatException e) {
           if (this.search_term.length() > 2){
               term= "s"
           } else{
               term = "f"
           }
       }


       List<Meal> Temp_list = new ArrayList<>();
       HttpClient client = HttpClient.create(this.UrlBase.toURL())
         HttpRequest request = HttpRequest.GET(UriBuilder.of('/api/json/v1/1/search.php')
                 .queryParam(term, this.search_term)
                 .build())

        HttpResponse<String> resp = client.toBlocking().exchange(request,String)


       try {
           String json = resp.body()
           JSONObject obj = new JSONObject(json);
           JSONArray arr = obj.optJSONArray("meals");
           for (int i = 0; i < arr.length(); i++)
           {

               def meal = new Meal();

               meal.meal_Id = arr.getJSONObject(i).optString("idMeal","None").toInteger();
               meal.name =  arr.getJSONObject(i).optString("strMeal","None");
               meal.drink = arr.getJSONObject(i).optString("strDrinkAlternate","None");
               meal.area = arr.getJSONObject(i).optString("strArea","None");
               meal.category = arr.getJSONObject(i).optString("strCategory","None");
               meal.tags = arr.getJSONObject(i).optString("strTags","None");
               meal.creative = arr.getJSONObject(i).optString("strCreativeCommonsConfirmed","None");
               meal.image = arr.getJSONObject(i).optString("strMealThumb","None");
               meal.instructions = arr.getJSONObject(i).optString("strInstructions","None");
               println(arr.getJSONObject(i).keys())

               for ( int j = 1 ; j <= 20 ; j++) {

                       String ingredient_key = "strIngredient" + j



                           Ingredient ingredient = new Ingredient();
                           ingredient.name = arr.getJSONObject(i).optString(ingredient_key,"");
                           meal.addToIngredients(ingredient);


                         String measure_key = "strMeasure" + j



                             Measure measure = new Measure();
                             measure.name = arr.getJSONObject(i).optString(measure_key,"");
                             meal.addToMeasures(measure);


               }
               Temp_list.add(meal);
           }

           return Temp_list


       }catch(NullPointerException e){
           return Temp_list
       }


     }
}
