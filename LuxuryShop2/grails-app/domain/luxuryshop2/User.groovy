package luxuryshop2

class User {

    String name
    String emailAdresse
    String passwort

    static constraints = {
    }

    static hasMany = [Bestellung:Bestellung]
}
