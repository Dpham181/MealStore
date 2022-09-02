package MealStore

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MeasureServiceSpec extends Specification {

    MeasureService measureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Measure(...).save(flush: true, failOnError: true)
        //new Measure(...).save(flush: true, failOnError: true)
        //Measure measure = new Measure(...).save(flush: true, failOnError: true)
        //new Measure(...).save(flush: true, failOnError: true)
        //new Measure(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //measure.id
    }

    void "test get"() {
        setupData()

        expect:
        measureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Measure> measureList = measureService.list(max: 2, offset: 2)

        then:
        measureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        measureService.count() == 5
    }

    void "test delete"() {
        Long measureId = setupData()

        expect:
        measureService.count() == 5

        when:
        measureService.delete(measureId)
        sessionFactory.currentSession.flush()

        then:
        measureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Measure measure = new Measure()
        measureService.save(measure)

        then:
        measure.id != null
    }
}
