import validis.reports.Report
import validis.reports.User

class BootStrap {

    def init = { servletContext ->
        // Create some users - as it won't be possible from UI
        def bond = new User(name: 'James Bond 007', locale: Locale.UK).save()
        def ryan = new User(name: 'Jack Ryan', locale: Locale.FRANCE).save()
        new User(name: 'Jason Bourne', locale: Locale.US).save()
        new User(name: 'Sam Fisher', locale: Locale.UK).save()

        // And some reports
        new Report(reportName: 'report_1', user: bond).save()
        new Report(reportName: 'report_2', user: ryan).save()
        new Report(reportName: 'report_3', user: bond).save()
    }

    def destroy = {
    }
}
