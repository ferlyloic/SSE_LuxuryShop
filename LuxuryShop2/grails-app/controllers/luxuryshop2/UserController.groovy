package luxuryshop2

class UserController {

    def index() { }
    def login() {
        if (params.username == "admin" && params.password == "admin"){
            flash.message = "login succed"
            session.user = "admin"
        }else{
            flash.message = "login failed"
        }
        redirect(action: 'index')
    }

    def logout() {
         session.user = null

        redirect(action: 'index')
    }
}
