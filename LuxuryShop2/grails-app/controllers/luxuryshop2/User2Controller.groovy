package luxuryshop2

class User2Controller {

    def index() { }
    def login() {
        if (params.username == "admin" && params.password == "admin"){
            flash.message = "login succeed"
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
