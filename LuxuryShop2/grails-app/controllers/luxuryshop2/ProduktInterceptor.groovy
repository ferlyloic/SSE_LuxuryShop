package luxuryshop2


class ProduktInterceptor {
    ProduktService produktService
        boolean gestartet = false

    boolean before() {

        if(!gestartet){
            produktService.save(new  Produkt(produktname: "Test", preis: 10, waehrung: Waehrung.Euro, produktbeschreibung: ""))
            println "loool "
            gestartet= true
        }

        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
