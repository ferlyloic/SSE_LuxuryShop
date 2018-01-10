package luxuryshop2

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class WelcomeInterceptorSpec extends Specification implements InterceptorUnitTest<WelcomeInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test welcome interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"welcome")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
