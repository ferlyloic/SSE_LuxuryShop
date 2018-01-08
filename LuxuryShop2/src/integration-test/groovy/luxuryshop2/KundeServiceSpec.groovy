package luxuryshop2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class KundeServiceSpec extends Specification {

    KundeService kundeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Kunde(...).save(flush: true, failOnError: true)
        //new Kunde(...).save(flush: true, failOnError: true)
        //Kunde kunde = new Kunde(...).save(flush: true, failOnError: true)
        //new Kunde(...).save(flush: true, failOnError: true)
        //new Kunde(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //kunde.id
    }

    void "test get"() {
        setupData()

        expect:
        kundeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Kunde> kundeList = kundeService.list(max: 2, offset: 2)

        then:
        kundeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        kundeService.count() == 5
    }

    void "test delete"() {
        Long kundeId = setupData()

        expect:
        kundeService.count() == 5

        when:
        kundeService.delete(kundeId)
        sessionFactory.currentSession.flush()

        then:
        kundeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Kunde kunde = new Kunde()
        kundeService.save(kunde)

        then:
        kunde.id != null
    }
}
