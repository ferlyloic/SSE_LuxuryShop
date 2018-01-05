package luxuryshop2

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class BankInterceptorSpec extends Specification implements InterceptorUnitTest<BankInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test bank interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"bank")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
