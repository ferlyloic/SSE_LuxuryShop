package luxuryshop2

class Kunde {
    String name
    String emailAdresse
    String passwort

    static constraints = {
        name nullable: false, blank: false
        emailAdresse nullable: false
        passwort nullable: false ,passwort: true
    }

    static hasMany = [bestellung: Bestellung]
}
