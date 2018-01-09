package luxuryshop2

import com.opencsv.CSVReader


class BankInterceptor {

   BankService bankService
    boolean gestartet = false

    boolean before() {
        gestartet = true
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
