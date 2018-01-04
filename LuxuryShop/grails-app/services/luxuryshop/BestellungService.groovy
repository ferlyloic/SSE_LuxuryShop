package luxuryshop

import grails.gorm.services.Service

@Service(Produkt)
interface BestellungService {

    Produkt get(Serializable id)

    List<Bestellung> list(Map args)

    Long count()

    void delete(Serializable id)

    Produkt save(Bestellung bestellung)

}