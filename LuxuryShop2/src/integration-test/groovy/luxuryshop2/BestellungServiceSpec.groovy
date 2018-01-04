package luxuryshop2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BestellungServiceSpec extends Specification {

    BestellungService bestellungService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Bestellung(...).save(flush: true, failOnError: true)
        //new Bestellung(...).save(flush: true, failOnError: true)
        //Bestellung bestellung = new Bestellung(...).save(flush: true, failOnError: true)
        //new Bestellung(...).save(flush: true, failOnError: true)
        //new Bestellung(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bestellung.id
    }

    void "test get"() {
        setupData()

        expect:
        bestellungService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Bestellung> bestellungList = bestellungService.list(max: 2, offset: 2)

        then:
        bestellungList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bestellungService.count() == 5
    }

    void "test delete"() {
        Long bestellungId = setupData()

        expect:
        bestellungService.count() == 5

        when:
        bestellungService.delete(bestellungId)
        sessionFactory.currentSession.flush()

        then:
        bestellungService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Bestellung bestellung = new Bestellung()
        bestellungService.save(bestellung)

        then:
        bestellung.id != null
    }
}
