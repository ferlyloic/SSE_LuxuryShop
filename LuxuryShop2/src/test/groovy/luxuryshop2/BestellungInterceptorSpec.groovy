package luxuryshop2

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class BestellungInterceptorSpec extends Specification implements InterceptorUnitTest<BestellungInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test bestellung interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"bestellung")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
