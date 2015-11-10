package validis.reports

class ReportIntegrationSpec extends GrailsIntegrationSpec {

    void 'returns report name for a user with UK locale'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK)
        3.times { user.addReport() }
        user.save()

        expect:
        Report.list()*.reportName.sort() == ['report_1', 'report_2', 'report_3']
        user.reportNames*.name.sort() == ['report_1', 'report_2', 'report_3']
    }

    void 'returns report name for a user with FRANCE locale'() {
        given:
        def user = new User(name: 'David', locale: Locale.FRANCE)
        3.times { user.addReport() }
        user.save()

        expect:
        Report.list()*.reportName.sort() == ['report_1', 'report_2', 'report_3']
        user.reportNames*.name.sort() == ['ercbeg_1', 'ercbeg_2', 'ercbeg_3']
    }

    // Report deletion is not supported.
}