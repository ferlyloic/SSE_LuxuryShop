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

        CSVReader reader = new CSVReader(new FileReader("files/ProductList.csv"));
    //    CSVReader reader = new CSVReader(new FileReader("/Users/jacquelinefranssen/Desktop/SSE_LuxuryShop/SSE_LuxuryShop/LuxuryShop2/grails-app/files/ProductList.csv"), ',');

        List<Produkt> produktList = new ArrayList<Produkt>();

        // read line by line
        String[] record = null;

        while ((record = reader.readNext()) != null) {
            Produkt produkt = new Produkt();
            produkt.name(record[0]);
            produkt.preis(record[1]);
            produkt.waehrung(Waehrung.Euro);
            produkt.produktbeschreibung(record[3]);
            produktList.add(produkt);
        }

        System.out.println(produktList);

        reader.close();
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
