package luxuryshop2

import com.opencsv.CSVReader

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



class ProduktInterceptor {
    ProduktService produktService
    boolean gestartet = false

    boolean before() {

        CSVReader reader = new CSVReader(new FileReader("grails-app/files/ProductList.csv"));
    //    CSVReader reader = new CSVReader(new FileReader("/Users/jacquelinefranssen/Desktop/SSE_LuxuryShop/SSE_LuxuryShop/LuxuryShop2/grails-app/files/ProductList.csv"), ',');

        List<Produkt> produktList = new ArrayList<Produkt>();

        // read line by line
        String[] record = null;
        reader.readNext()

        while ((record = reader.readNext()) != null) {
            println(Arrays.asList(record))
            Produkt produkt = new Produkt(produktname: record[0],preis: Double.parseDouble(record[1]), waehrung: Waehrung.Euro, produktbeschreibung:  record[2]);
            println produkt
            produktService.save(produkt)
        }

        reader.close();
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
