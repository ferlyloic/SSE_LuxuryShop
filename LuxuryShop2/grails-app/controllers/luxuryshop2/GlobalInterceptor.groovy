package luxuryshop2

import com.opencsv.CSVReader


class GlobalInterceptor {
    ProduktService produktService
    BankService bankService
    KundeService kundeService
    AdminService adminService
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
            initAdmin()
            isInitialisiert = true
        }
        true
    }

    void initAdmin() {
        Admin admin = new Admin(name: 'admin', passwort: 'admin')
        adminService.save(admin)
    }

    void initProdukte() {

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
        CSVReader reader = new CSVReader(new FileReader("grails-app/files/Bank.csv"));
        // read line by line
        String[] record = null;
        println reader.readNext()
        while ((record = reader.readNext()) != null) {
            println(Arrays.asList(record))
//            Bank bank = new Bank(kundenName: record[0],kreditkartennummer: record[1], saldo: Double.parseDouble(record[2]),
//                    waehrung: Waehrung.Euro);
            Bank bank = new Bank(kreditkartennummer: record[0], saldo: Double.parseDouble(record[1]),
                    waehrung: Waehrung.Euro);
            println bank
            bankService.save(bank)
        }

        reader.close();
    }
    void initKunden() {

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
