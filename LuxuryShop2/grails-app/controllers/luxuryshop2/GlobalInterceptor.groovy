package luxuryshop2

import com.opencsv.CSVReader


class GlobalInterceptor {

    public GlobalInterceptor() {
        match controllerNamespace: 'luxuryshop2'
        //   match controller: 'KundeController'
    }
    boolean isInitialisiert = false
    boolean before() {
        println "${this.controllerName} aufgerufen !!!"
        if(!isInitialisiert){
            initProdukte()
            initKunden()
            initBank()
            isInitialisiert = true
        }
        true
    }

    void initProdukte() {
        ProduktService produktService
        CSVReader reader = new CSVReader(new FileReader("grails-app/files/ProductList.csv"));
        // read line by line
        String[] record = null;
        println reader.readNext()
        while ((record = reader.readNext()) != null) {
            println(Arrays.asList(record))
            Produkt produkt = new Produkt(produktname: record[0],preis: Double.parseDouble(record[1]), waehrung: Waehrung.Euro, produktbeschreibung:  record[2]);
            //println produkt
            produktService.save(produkt)
        }

        reader.close()
    }
    void initBank() {
        BankService bankService
        CSVReader reader = new CSVReader(new FileReader("grails-app/files/Bank.csv"));
        // read line by line
        String[] record = null;
        println reader.readNext()
        while ((record = reader.readNext()) != null) {
            println(Arrays.asList(record))
            Bank bank = new Bank(kundenName: record[0],kreditkartennummer: Integer.parseInt(record[1]), saldo: Double.parseDouble(record[2]),
                    waehrung: Waehrung.Euro);
            println bank
            bankService.save(bank)
        }

        reader.close();
    }
    void initKunden() {
        KundeService kundeService
        CSVReader reader = new CSVReader(new FileReader("grails-app/files/Kunde.csv"));
        // read line by line
        String[] record = null;
        println reader.readNext()
        while ((record = reader.readNext()) != null) {
            println(Arrays.asList(record))
            Kunde kunde = new Kunde(name: record[0], emailAdresse: record[1], passwort: record[2])
            println kunde
            kundeService.save(kunde)
        }

        reader.close();
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
