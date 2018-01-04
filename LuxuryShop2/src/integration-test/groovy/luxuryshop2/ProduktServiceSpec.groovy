package luxuryshop2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProduktServiceSpec extends Specification {

    ProduktService produktService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Produkt(...).save(flush: true, failOnError: true)
        //new Produkt(...).save(flush: true, failOnError: true)
        //Produkt produkt = new Produkt(...).save(flush: true, failOnError: true)
        //new Produkt(...).save(flush: true, failOnError: true)
        //new Produkt(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //produkt.id
    }

    void "test get"() {
        setupData()

        expect:
        produktService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Produkt> produktList = produktService.list(max: 2, offset: 2)

        then:
        produktList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        produktService.count() == 5
    }

    void "test delete"() {
        Long produktId = setupData()

        expect:
        produktService.count() == 5

        when:
        produktService.delete(produktId)
        sessionFactory.currentSession.flush()

        then:
        produktService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Produkt produkt = new Produkt()
        produktService.save(produkt)

        then:
        produkt.id != null
    }
}
