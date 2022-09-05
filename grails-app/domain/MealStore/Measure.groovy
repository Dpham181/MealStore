package MealStore

class Measure {
    String name;
    String toString() {
        "${name}"
    }
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
