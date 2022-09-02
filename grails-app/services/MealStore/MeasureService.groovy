package MealStore

import grails.gorm.services.Service

@Service(Measure)
interface MeasureService {

    Measure get(Serializable id)

    List<Measure> list(Map args)

    Long count()

    void delete(Serializable id)

    Measure save(Measure measure)

}