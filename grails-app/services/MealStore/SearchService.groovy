package MealStore


import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.uri.UriBuilder
import io.micronaut.http.client.HttpClient
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

class SearchService {
     String UrlBase ="https://www.themealdb.com/" ;
     String term;
     String search_term;


     SearchService(String term, String search_term){
        this.term = term ;
         this.search_term = search_term;
    };

   List<Meal> serviceMethod(){
      
       List<Meal> Temp_list = new ArrayList<>();
       HttpClient client = HttpClient.create(this.UrlBase.toURL())
         HttpRequest request = HttpRequest.GET(UriBuilder.of('/api/json/v1/1/search.php')
                 .queryParam(this.term, this.search_term)
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
               meal.image = arr.getJSONObject(i).optString("strImageSource","None");
               meal.instructions = arr.getJSONObject(i).optString("strInstructions","None");
               for ( int j = 0 ; j < arr.getJSONObject(i).keySet().size() ; j++) {

                   if(arr.getJSONObject(i).keySet()[j].toString().contains("Ingredient")){
                       String key = arr.getJSONObject(i).keySet()[j];



                       Ingredient ingredient = new Ingredient();
                       ingredient.name = arr.getJSONObject(i).optString(key,"None");
                       meal.addToIngredients(ingredient);


                   }
               }

               Temp_list.add(meal);
           }

           return Temp_list


       }catch(NullPointerException e){
           return Temp_list
       }


     }
}
