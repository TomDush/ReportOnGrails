package validis.reports

import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class ReportGeneratorSpec extends Specification {

    def reportGenerator

    void setup() {
//        reportGenerator = new ReportGenerator()
    }

    void 'adds a report to the user'() {
        given:
        def user = Mock(User)
        def reportName = 'report_1'

        when:
        def newReportName = reportGenerator.addReport(user)

        then:
        1 * user.addReport() >> reportName
        newReportName == reportName
    }
}