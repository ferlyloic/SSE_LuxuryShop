package luxuryshop2

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class KundeController {

    KundeService kundeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login() {
        if (params.name == "kunde" && params.password == "kund"){
            flash.message = "login succeed"
            session.kunde = "kunde"
            redirect(action: 'login')
        }else{
            flash.message = "login failed"
        }

    }



    def logout() {
        session.user = null
        redirect(action: 'index')
    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond kundeService.list(params), model:[kundeCount: kundeService.count()]
    }

    def show(Long id) {
        respond kundeService.get(id)
    }

    def create() {
        respond new Kunde(params)
    }

    def save(Kunde kunde) {
        if (kunde == null) {
            notFound()
            return
        }

        try {
            kundeService.save(kunde)
        } catch (ValidationException e) {
            respond kunde.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kunde.label', default: 'Kunde'), kunde.id])
                redirect kunde
            }
            '*' { respond kunde, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond kundeService.get(id)
    }

    def update(Kunde kunde) {
        if (kunde == null) {
            notFound()
            return
        }

        try {
            kundeService.save(kunde)
        } catch (ValidationException e) {
            respond kunde.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'kunde.label', default: 'Kunde'), kunde.id])
                redirect kunde
            }
            '*'{ respond kunde, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        kundeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'kunde.label', default: 'Kunde'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kunde.label', default: 'Kunde'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
