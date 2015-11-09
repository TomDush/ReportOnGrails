package validis.reports

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Report)
class ReportBaseSpec extends EqualsHashCodeSpec {

    @Override
    protected createObjectToCompare() {
        new Report(user: new User(id: 1, name: 'Ironman'), reportName: 'report_1')
    }

    @Override
    protected modifiedPropertiesIncludedInEqualsAndHashCode() {
        [user: new User(id: 2, name: 'Blackwidow'), reportName: 'report_2']
    }
}
