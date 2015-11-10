package validis.reports

class UserIntegrationSpec extends GrailsIntegrationSpec {

    void 'adds a new report'() {
        given:
        def user = new User(name: 'David', locale: Locale.UK).save()

        when:
        def reportName = user.addReport()

        then:
        Report.all.size() == old(Report.all.size()) + 1
        reportName == Report.last().reportName
    }
}
