package luxuryshop

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BestellungController {

    BestellungService bestellungService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bestellungService.list(params), model:[bestellungCount: bestellungService.count()]
    }

    def show(Long id) {
        respond bestellungService.get(id)
    }

    def create() {
        respond new Bestellung(params)
    }

    def save(Bestellung bestellung) {
        if (bestellung == null) {
            notFound()
            return
        }

        try {
            if(bestellung.bestellungsstatus == null){
                bestellung.bestellungsstatus = Bestellungsstatus.Unbezahlt
            }
            bestellungService.save(bestellung)
        } catch (ValidationException e) {
            respond bestellung.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bestellung.label', default: 'Bestellung'), bestellung.id])
                redirect bestellung
            }
            '*' { respond bestellung, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bestellungService.get(id)
    }

    def update(Bestellung bestellung) {
        if (bestellung == null) {
            notFound()
            return
        }

        try {
            bestellungService.save(bestellung)
        } catch (ValidationException e) {
            respond bestellung.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bestellung.label', default: 'Bestellung'), bestellung.id])
                redirect bestellung
            }
            '*'{ respond bestellung, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bestellungService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bestellung.label', default: 'Bestellung'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bestellung.label', default: 'Bestellung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
