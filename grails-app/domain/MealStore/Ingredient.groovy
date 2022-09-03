package MealStore

class Ingredient {
    String name;
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
