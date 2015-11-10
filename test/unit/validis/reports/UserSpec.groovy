package validis.reports

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(User)
class UserSpec extends Specification {

    private user

    void setup() {
        user = new User(name: 'David', locale: Locale.UK)
    }

    void "null required fields shouldn't validate"() {
        setup:
        user.locale = null

        expect:
        !user.validate()
    }

    void "blank required fields shouldn't validate"() {
        setup:
        user.name = ''

        expect:
        !user.validate()
    }

    void "returns the list of reports name converted according to the user's locale"() {
        given:
        def (firstReport, secondReport) = [reportMock(id: 1), reportMock(id: 2)]
        user.reports = [firstReport, secondReport]

        and:
        def reportNameConverter = Mock(ReportNameConverter)
        reportNameConverter.convert(_, _) >>> ['report_1', 'report_2']
        user.reportNameConverter = reportNameConverter

        when:
        def reportNames = user.reportNames

        then:
        reportNames == [[name: 'report_1'], [name: 'report_2']]
    }

    private reportMock(args) {
        [name: "report_${args.id}"]
    }
}
