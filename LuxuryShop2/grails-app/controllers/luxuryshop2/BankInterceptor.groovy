package luxuryshop2

import com.opencsv.CSVReader


class BankInterceptor {

   BankService bankService
    boolean gestartet = false

    boolean before() {
        if(!gestartet){
            CSVReader reader = new CSVReader(new FileReader("grails-app/files/Bank.csv"));

            List<Bank> bankList = new ArrayList<Bank>();

            // read line by line
            String[] record = null;
            println reader.readNext()
            while ((record = reader.readNext()) != null) {
                println(Arrays.asList(record))
                Bank bank = new Bank(kundenName: record[0],kreditkartennummer: record[1], saldo: Double.parseDouble(record[2]),
                        waehrung: Waehrung.Euro);
                println bank
                bankService.save(bank)
            }

            reader.close();
        }
        gestartet = true
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
