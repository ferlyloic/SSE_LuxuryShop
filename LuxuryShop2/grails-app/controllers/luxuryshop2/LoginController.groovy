package luxuryshop2

import org.omg.CORBA.Object

class LoginController {


    KundeService kundeService
    AdminService adminService
    def index() {
        redirect(action: "login")
    }

    def login(){
       if(session.idx) {
            if(session.role == Admin.getSimpleName()){
                redirect(controller: "kunde", action: "index")
            }else {
                redirect(controller: "kunde", action: "edit", id: session.idx)
            }
        }

        if(params.containsKey("kundenname") && params.containsKey("password")){
            Kunde ku
            ArrayList<Kunde> kunden = kundeService.list()
               for(Kunde k: kunden){
                   if(params.kundenname == k.name && params.password == k.passwort){
                       ku = k
                       break
                   }
               }
            if(ku != null){
                println(ku)
                flash.message = "login succeed"
                Long idx = ku.getId()
                println(ku)
                session.idx = idx
                session.role = Kunde.getSimpleName()
                redirect(controller: "kunde", action: "show", id: idx)
            } else {
                Admin ad
                ArrayList<Admin> admins = adminService.list()
                for(Admin a: admins){
                    if(params.kundenname == a.name && params.password == a.passwort){
                        ad = a
                        break
                    }
                }
                if(ad != null){
                    println(ad)
                    flash.message = "login succeed"
                    Long idx = ad.getId()
                    session.idx = idx
                    session.role = Admin.getSimpleName()
                    redirect(controller: "admin", action: "show", id: idx)
                } else {
                    println("login failed")
                    flash.message = "login failed"
                    //render("User name or password false try again !!!")
                    redirect(action: "login")
                }
            }
        }
    }
    def logout(){
        session.invalidate()
        flash.message = "logout successful"
        redirect( action: "login")
    }

    def error() {

    }
}
