package luxuryshop2

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class BankController {

    BankService bankService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bankService.list(params), model:[bankCount: bankService.count()]
    }

    def show(Long id) {
        respond bankService.get(id)
    }

    def create() {
        respond new Bank(params)
    }

    def save(Bank bank) {
        if (bank == null) {
            notFound()
            return
        }

        try {
            bankService.save(bank)
        } catch (ValidationException e) {
            respond produkt.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bank.label', default: 'Bank'), produkt.id])
                redirect produkt
            }
            '*' { respond produkt, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bankService.get(id)
    }

    def update(Bank bank) {
        if (bank == null) {
            notFound()
            return
        }

        try {
            bankService.save(bank)
        } catch (ValidationException e) {
            respond bank.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bank.label', default: 'Bank'), bank.id])
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

        bankService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bank.label', default: 'Bank'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bank.label', default: 'Bank'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
