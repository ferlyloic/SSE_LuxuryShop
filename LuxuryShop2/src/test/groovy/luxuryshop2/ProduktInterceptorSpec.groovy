package luxuryshop2

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ProduktInterceptorSpec extends Specification implements InterceptorUnitTest<ProduktInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test produkt interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"produkt")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
