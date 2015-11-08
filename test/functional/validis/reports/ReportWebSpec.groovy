package validis.reports

import geb.spock.GebReportingSpec
import org.junit.Ignore
import validis.reports.pages.UserPage

class ReportWebSpec extends GebReportingSpec {

    void 'shows user name and reports of a user with UK locale'() {
        //TODO Do not load data in bootstrap and use specific fixtures for each test scenario
        when:
        to UserPage, 1

        then:
        userName == 'David'
        userReports == ['report_1', 'report_2', 'report_3']
    }

    @Ignore
    void 'shows user name and reports of a user with FRANCE locale'() {
        //TODO
    }

    @Ignore
    void 'adds a new report for a user with UK locale'() {
        //TODO
    }

    @Ignore
    void 'adds a new report for a user with FRANCE locale'() {
        //TODO
    }
}
