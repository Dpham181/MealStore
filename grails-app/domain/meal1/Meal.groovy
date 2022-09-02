package meal1

class Meal {
    String meal_Id;
    String name;
    String drink;
    String category;
    String area;
    String instructions;
    String tags;
    List  ingredients;
    List  measures;
    String image;
    String creative;
    Date dateModified;
    static HasMany = [ingredients:Ingredient,measures:Measure]

    static constraints = {
         meal_Id();
         name();
         drink();
         category();
         area();
         instructions();
         tags();
          ingredients();
          measures();
         image();
         creative();
         dateModified();
        instructions maxSize:5000
    }

}
