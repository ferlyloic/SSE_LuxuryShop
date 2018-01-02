package luxuryshop

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
        waehrung defaultValue: Waehrung.Euro
        produktbeschreibung defaulValue: "bla"

    }
    @Override
    public String toString(){
        "$produktname ,$preis $waehrung: $produktbeschreibung"
    }
}
