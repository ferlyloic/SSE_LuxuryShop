package luxuryshop2


class GlobalInterceptor {

    public GlobalInterceptor() {
        match controllerNamespace: 'luxuryshop2'
        match controller: 'BankController', action: 'index'
        match controller: 'BestellungController', action: 'index'
        match controller: 'ProduktController', action: 'index'
        match controller: 'KundeController', action: 'index'


        //   match controller: 'KundeController'
    }

    boolean before() {
        params.firstInterceptorRan = 'yes'
        println "${this.controllerName} aufgerufen !!!"
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
