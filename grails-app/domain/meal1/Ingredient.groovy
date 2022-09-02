package meal1

class Ingredient {
    String name;
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
