package MealStore

class Meal {
    String meal_Id;
    String name;
    String drink;
    String category;
    String area;
    String instructions;
    List ingredients;
    String tags;
    String image;
    String creative;
    static hasMany  = [ingredients:Ingredient, measures:Measure]

    static constraints = {
         meal_Id();
         name();
         drink();
         category();
         area();
         instructions();
         tags();
         image();
         creative();
        instructions maxSize:5000
    }

}
