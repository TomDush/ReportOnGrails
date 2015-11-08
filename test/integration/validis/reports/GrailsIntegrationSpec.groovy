package validis.reports

import grails.test.spock.IntegrationSpec

class GrailsIntegrationSpec extends IntegrationSpec {

    def sessionFactory

    void setup() {
        User.list()*.delete()
        Report.list()*.delete()

        sessionFactory.currentSession.flush()
        sessionFactory.currentSession.clear()
    }
}
