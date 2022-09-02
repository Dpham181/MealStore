package MealStore

class Meal {
    String meal_Id;
    String name;
    String drink;
    String category;
    String area;
    String instructions;
    String tags;
    String image;
    String creative;
    Date dateModified;
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
         dateModified();
        instructions maxSize:5000
    }

}
