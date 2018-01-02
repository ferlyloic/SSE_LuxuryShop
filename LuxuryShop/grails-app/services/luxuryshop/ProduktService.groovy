package luxuryshop

import grails.gorm.services.Service

@Service(Produkt)
interface ProduktService {

    Produkt get(Serializable id)

    List<Produkt> list(Map args)

    Long count()

    void delete(Serializable id)

    Produkt save(Produkt produkt)

}