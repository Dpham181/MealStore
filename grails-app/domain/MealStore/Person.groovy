package MealStore

class Person {
        String name
        Integer age
        Date lastVisit
        static hasMany  = [ingredients: Ingredient, measures: Measure]



    static constraints = {
    }
}
