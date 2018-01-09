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
        println(gestartet)

        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
