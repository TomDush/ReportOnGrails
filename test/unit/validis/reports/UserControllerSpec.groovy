package validis.reports

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UserController)
@Mock([User, Report])
class UserControllerSpec extends Specification {

    void 'shows the user'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK).save()

        when:
        controller.show(user.id)

        then:
        view == '/user/show'
        model.user == user
    }

    void 'returns the list of reports for a particular user'() {
        given:
        def user = new User(name: 'Tom', locale: Locale.UK).save()
        new Report(user: user, reportName: 'report_1').save()
        new Report(user: user, reportName: 'report_2').save()

        and:
        def reportNameConverter = Mock(ReportNameConverter)
        reportNameConverter.convert(_, _) >>> ['rapport_1', 'rapport_2']

        controller.reportNameConverter = reportNameConverter

        when:
        controller.getReports(user.id)

        then:
        response.text == '[{"name":"rapport_1"},{"name":"rapport_2"}]'
    }

    void 'returns the new report added to the user'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK)
        def reportName = 'report_1'
        def reportGenerator = Mock(ReportGenerator)
        controller.reportGenerator = reportGenerator

        when:
        controller.addReport(user)

        then:
        1 * reportGenerator.addReport(user) >> reportName
        response.text == '{"name":"report_1"}'
    }
}
