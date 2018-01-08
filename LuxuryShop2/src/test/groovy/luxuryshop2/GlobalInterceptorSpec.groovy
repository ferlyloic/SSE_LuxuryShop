package luxuryshop2

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class GlobalInterceptorSpec extends Specification implements InterceptorUnitTest<GlobalInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test globalInteceptor interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"globalInteceptor")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
