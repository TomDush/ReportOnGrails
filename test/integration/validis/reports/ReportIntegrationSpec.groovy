package validis.reports

class ReportIntegrationSpec extends GrailsIntegrationSpec {

    void 'returns report name for a user with UK locale'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK)
        3.times { user.addToReports(new Report(user: user)) }
        user.save()

        expect:
        Report.list()*.name.sort() == ['report_1', 'report_2', 'report_3']
    }

    void 'returns report name for a user with FRANCE locale'() {
        given:
        def user = new User(name: 'David', locale: Locale.FRANCE)
        3.times { user.addToReports(new Report(user: user)) }
        user.save()

        expect:
        Report.list()*.name.sort() == ['ercbeg_1', 'ercbeg_2', 'ercbeg_3']
    }

    void 'removes a report'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK)
        def (firstReport, secondReport) = [new Report(user: user), new Report(user: user)]
        user.addToReports(firstReport)
        user.addToReports(secondReport)
        user.save()

        expect:
        user.reports == [firstReport, secondReport]

        when:
        secondReport.remove()

        then:
        user.reports == [firstReport]
    }
}