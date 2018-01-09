package luxuryshop2

class Bank {

    String kundenName
    String kreditkartennummer
    BigDecimal saldo
    Waehrung waehrung



    static constraints = {
        kundenName(nullable: false, blank: false, unique: true)
        saldo(nullable: false, min: 0.01)
        waehrung(nullable: false)
        kreditkartennummer(nullable: false, blank: false, unique: true)
    }
    static mapping = {
        //WARNING: aufpassen bei der Nutzung von defaultValue es kann zu Probleme mit der Hibernate kommen.
        //produktbeschreibung defaultValue: 'keine Beschreibung vorhanden!!'

    }
    @Override
    public String toString(){
        """$kundenName
    $kreditkartennummer $saldo $waehrung:"""
    }
}
