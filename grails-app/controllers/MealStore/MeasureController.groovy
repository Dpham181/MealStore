package MealStore

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MeasureController {

    MeasureService measureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond measureService.list(params), model:[measureCount: measureService.count()]
    }

    def show(Long id) {
        respond measureService.get(id)
    }

    def create() {
        respond new Measure(params)
    }

    def save(Measure measure) {
        if (measure == null) {
            notFound()
            return
        }

        try {
            measureService.save(measure)
        } catch (ValidationException e) {
            respond measure.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'measure.label', default: 'Measure'), measure.id])
                redirect measure
            }
            '*' { respond measure, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond measureService.get(id)
    }

    def update(Measure measure) {
        if (measure == null) {
            notFound()
            return
        }

        try {
            measureService.save(measure)
        } catch (ValidationException e) {
            respond measure.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'measure.label', default: 'Measure'), measure.id])
                redirect measure
            }
            '*'{ respond measure, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        measureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'measure.label', default: 'Measure'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'measure.label', default: 'Measure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
