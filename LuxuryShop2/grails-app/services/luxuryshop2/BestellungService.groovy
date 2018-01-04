package luxuryshop2

import grails.gorm.services.Service

@Service(Bestellung)
interface BestellungService {

    Bestellung get(Serializable id)

    List<Bestellung> list(Map args)

    Long count()

    void delete(Serializable id)

    Bestellung save(Bestellung bestellung)

}