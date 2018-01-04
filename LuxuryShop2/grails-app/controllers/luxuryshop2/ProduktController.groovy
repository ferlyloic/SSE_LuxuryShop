package luxuryshop2

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProduktController {

    ProduktService produktService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond produktService.list(params), model:[produktCount: produktService.count()]
    }

    def show(Long id) {
        respond produktService.get(id)
    }

    def create() {
        respond new Produkt(params)
    }

    def save(Produkt produkt) {
        if (produkt == null) {
            notFound()
            return
        }

        try {
            produktService.save(produkt)
        } catch (ValidationException e) {
            respond produkt.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'produkt.label', default: 'Produkt'), produkt.id])
                redirect produkt
            }
            '*' { respond produkt, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond produktService.get(id)
    }

    def update(Produkt produkt) {
        if (produkt == null) {
            notFound()
            return
        }

        try {
            produktService.save(produkt)
        } catch (ValidationException e) {
            respond produkt.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'produkt.label', default: 'Produkt'), produkt.id])
                redirect produkt
            }
            '*'{ respond produkt, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        produktService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'produkt.label', default: 'Produkt'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'produkt.label', default: 'Produkt'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
