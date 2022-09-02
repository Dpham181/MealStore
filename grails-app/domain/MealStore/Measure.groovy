package MealStore

class Measure {
    String strMeasure;
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
