package luxuryshop2

class Kunde {
    String name
    String emailAdresse
    String passwort

    static constraints = {
        name nullable: false, blank: false, unique: true
        emailAdresse nullable: false
        passwort nullable: false ,passwort: true
    }

    static hasMany = [bestellungen: Bestellung]

    @Override
    String toString() {
        """$name $emailAdresse"""
    }
}
