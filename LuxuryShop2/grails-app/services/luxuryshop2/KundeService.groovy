package luxuryshop2

import grails.gorm.services.Service

@Service(Kunde)
interface KundeService {

    Kunde get(Serializable id)

    List<Kunde> list(Map args)

    Long count()

    void delete(Serializable id)

    Kunde save(Kunde kunde)

}