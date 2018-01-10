


class WelcomeInterceptor {

    boolean before() { true }

    boolean after() {
        println this.controllerNamespace +" welcome"
//        redirect( controller: "login")
        true
    }

    void afterView() {

        // no-op
    }
}
