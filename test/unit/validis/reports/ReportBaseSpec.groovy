package validis.reports

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(Report)
@Mock(User)
class ReportBaseSpec extends EqualsHashCodeSpec {

    @Override
    protected createObjectToCompare() {
        new Report(user: new User(id: 1, name: 'Ironman', locale: Locale.US), reportName: 'report_1')
    }

    @Override
    protected modifiedPropertiesIncludedInEqualsAndHashCode() {
        [user: new User(id: 2, name: 'Blackwidow', locale: Locale.GERMAN), reportName: 'report_2']
    }

    def 'are not equals'() {
        given:
        def report1 = new Report(user: new User(id: 1, name: 'Ironman', locale: Locale.US).save(), reportName: 'report_1')
        def report2 = new Report(user: new User(id: 2, name: 'Blackwidow', locale: Locale.GERMAN).save(), reportName: 'report_1')

        expect:
        !report1.equals(report2)

    }
}
