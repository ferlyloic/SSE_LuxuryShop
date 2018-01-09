package luxuryshop2

class Admin {


    String name
    String passwort

    static constraints = {
        name nullable: false, blank: false
        passwort nullable: false
    }

}
