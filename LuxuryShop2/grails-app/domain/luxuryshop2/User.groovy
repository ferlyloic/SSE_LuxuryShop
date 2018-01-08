package luxuryshop2

class User {

    String name
    String emailAdresse
    String passwort

    static constraints = {
        name nullable: false, blank: false
        emailAdresse nullable: false
        passwort nullable: false
    }

    static hasMany = [Bestellung:Bestellung]
}
