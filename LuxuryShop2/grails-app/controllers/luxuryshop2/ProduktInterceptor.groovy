package luxuryshop2

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



class ProduktInterceptor {
    ProduktService produktService
    boolean gestartet = false

    boolean before() {

        if(!gestartet){
           /** produktService.save(new Produkt(produktname: "Test", preis: 10, waehrung: Waehrung.Euro, produktbeschreibung: ""))
            println "loool "**/
            String csvFile = "/Users/mkyong/csv/country.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);

                    System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            gestartet= true
        }

        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
