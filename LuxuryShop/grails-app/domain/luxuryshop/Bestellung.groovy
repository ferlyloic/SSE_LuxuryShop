package luxuryshop

class Bestellung {
    Produkt produkt
    Integer menge
    BigDecimal getGesamtpreis(){
        produkt.getPreis()* menge
    }
    Bestellungsstatus bestellungsstatus = Bestellungsstatus.Unbezahlt

    static constraints = {
        produkt(nullable: false)
        menge(nullable: false, min: 1)
        bestellungsstatus display: false
        gesamtpreis display: true
    }
    static mapping = {
        bestellungsstatus defaulValue: Bestellungsstatus.Unbezahlt
    }
    static transients = ['gesamtpreis']
}
