package MealStore

import grails.validation.ValidationException

import java.sql.Array

import static org.springframework.http.HttpStatus.*

class MealController {

    MealService mealService
    IngredientService ingredientService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    // search functions



    def index(Integer max) {

        params.max = Math.min(max ?: 10, 100)
        respond mealService.list(params), model:[mealCount: mealService.count()]
    }

    def show(Long id) {
        respond mealService.get(id)
    }

    def create() {


        respond new Meal(params)
    }

    def save(Meal meal) {
        if (meal == null) {
            notFound()
            return
        }

        try {
            def ingredients = params.ingredientss;

            for ( int i = 0 ; i < 20 ; i ++){
                Ingredient NEW = new Ingredient(name:ingredients[i])
                if(NEW.name === null){
                    NEW.name = " "
                }
                meal.addToIngredients(NEW);
            }
            mealService.save(meal)
        } catch (ValidationException e) {
            respond meal.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'meal.label', default: 'Meal'), meal.id])
                redirect meal
            }
            '*' { respond meal, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mealService.get(id)
    }

    def update(Meal meal) {
        if (meal == null) {
            notFound()
            return
        }

        try {
            mealService.save(meal)
        } catch (ValidationException e) {
            respond meal.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'meal.label', default: 'Meal'), meal.id])
                redirect meal
            }
            '*'{ respond meal, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mealService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'meal.label', default: 'Meal'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'meal.label', default: 'Meal'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
