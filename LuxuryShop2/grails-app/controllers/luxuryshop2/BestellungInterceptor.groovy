package luxuryshop2


class BestellungInterceptor {

    BestellungInterceptor(){
        //match controller:'bestellung', action: 'save'
    }

    boolean before() {
        //println params
        //println("Bestellung saved")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
