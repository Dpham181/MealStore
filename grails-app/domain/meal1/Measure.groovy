package meal1

class Measure {
    String strMeasure;
    static belongsTo = [meal: Meal]

    static constraints = {
    }
}
