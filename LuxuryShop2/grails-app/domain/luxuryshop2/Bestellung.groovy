package luxuryshop2

class Bestellung {
    Integer menge
    //BigDecimal getGesamtpreis(){
    //    produkt.getPreis()* menge
    //}
    Bestellungsstatus bestellungsstatus
    Produkt produkt

    static constraints = {
        produkt(nullable: false)
        menge(nullable: false, min: 1)
        bestellungsstatus display: false
        //gesamtpreis display: true
    }
    static mapping = {
       bestellungsstatus defaultValue: Bestellungsstatus.Unbezahlt
    }
    //static transients = ['gesamtpreis']
    static belongsTo = [kunde: Kunde]

}

