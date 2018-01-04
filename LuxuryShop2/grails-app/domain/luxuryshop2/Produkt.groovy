package luxuryshop2

class Produkt {

    String produktname
    BigDecimal preis
    Waehrung waehrung
    String produktbeschreibung

    static constraints = {
        produktname(nullable: false, blank: false, unique: true)
        preis(nullable: false, min: 0.01)
        waehrung(nullable: false)
        produktbeschreibung(nullable: true, blank: true)
    }
    static mapping = {
        //WARNING: aufpassen bei der Nutzung von defaultValue es kann zu Probleme mit der Hibernate kommen..
        waehrung defaultValue: Waehrung.Euro
        //produktbeschreibung defaultValue: 'keine Beschreibung vorhanden!!'

    }
    @Override
    public String toString(){
        """$produktname
$preis $waehrung:
$produktbeschreibung"""
    }
}
