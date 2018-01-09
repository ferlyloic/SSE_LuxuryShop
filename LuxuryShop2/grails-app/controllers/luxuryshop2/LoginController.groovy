package luxuryshop2

class LoginController {


    KundeService kundeService
    AdminService adminService
    def index() {
        redirect(action: 'login')

    }

    def login(){
        //kundeService.list()
        if (params.kundenname == "kunde" && params.password == "kunde"){
            flash.message = "login succeed"
            session.kunde = "kunde"
            redirect(controller: 'kunde', action: 'index')
        }else {
            flash.message = "login failed"
            render "irgendwas"

            //redirect(controller: this.controllerName, action: 'login')
        }
    }
}
