package luxuryshop2

import org.omg.CORBA.Object

class LoginController {


    KundeService kundeService
    AdminService adminService
    def index() {
        render("login")

    }

    def login(){
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
            Long l = kunden.indexOf(ku)+1
            println(l)
            redirect(controller: "kunde", action: "show", id: l)
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
                Long l = admins.indexOf(ad)+1
                println(l)
                redirect(controller: "admin", action: "show", id: l)
            } else {
                println("login failed")
                flash.message = "login failed"
                render("User name or password false try again !!!")
            }
        }
    }
}
