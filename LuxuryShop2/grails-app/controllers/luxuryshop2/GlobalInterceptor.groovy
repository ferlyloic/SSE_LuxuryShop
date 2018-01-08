package luxuryshop2


class GlobalInterceptor {

    public GlobalInterceptor(){
        match controllerNamespace: 'luxuryshop2'
    }

    boolean before() {
        println "${this.controllerName} aufgerufen !!!"
        true }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
