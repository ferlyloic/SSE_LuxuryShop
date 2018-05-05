package luxuryshop2

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class AdminController {

    AdminService adminService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login() {
        if (params.name == "admin" && params.password == "admin"){
            flash.message = "login succeed"
            session.kunde = "kunde"
            redirect(action: 'index')
        }else{
            flash.message = "login failed"
            redirect(action: 'index')
        }

    }
    def dashboard(){
        redirect(action: "index")
    }
    def bestellungsverwalung(){
        redirect(controller: "bestellung", action: "index")
    }
    def kundenverwaltung(){
        redirect(controller: "kunde", action: "index")
    }
    def produktverwaltung(){
        redirect(controller: "produkt", action: "index")
    }


    def logout() {
        session.user = null
        redirect(action: 'index')
    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond adminService.list(params), model:[adminCount: adminService.count()]
    }

    def show(Long id) {
        respond adminService.get(id)
    }



    def delete(Long id) {

        flash.message = "Du kannst das Admin nicht löschen !!!!"
        redirect(action: "index")
//        if (id == null) {
//            notFound()
//            return
//        }
//
//        adminService.delete(id)
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'admin.label', default: 'Admin'), id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'admin.label', default: 'Admin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

}
