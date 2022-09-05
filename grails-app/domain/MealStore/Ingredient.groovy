package MealStore

class Ingredient {
    String name;
    String toString() {
        "${name}"
    }
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
