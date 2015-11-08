package validis.reports

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Report)
class ReportBaseSpec extends EqualsHashCodeSpec {

    @Override
    protected createObjectToCompare() {
        new Report(id: 1)
    }

    @Override
    protected modifiedPropertiesIncludedInEqualsAndHashCode() {
        [id: 2]
    }
}
