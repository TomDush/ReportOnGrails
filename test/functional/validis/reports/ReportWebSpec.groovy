package validis.reports

import geb.spock.GebReportingSpec
import grails.plugin.remotecontrol.RemoteControl
import org.junit.Ignore
import validis.reports.pages.UserPage

class ReportWebSpec extends GebReportingSpec {

    void 'shows user name and reports of a user with UK locale'() {
        when: "A UK user with 2 reports exists"

        def remote = new RemoteControl()
        def userId = remote {
            def ukUser = new User(name: 'UK User', locale: Locale.UK).save()
            new Report(user: ukUser, reportName: 'report_1').save()
            new Report(user: ukUser, reportName: 'report_2').save()

            return ukUser.id
        }

        and: "Go to this user page"
        to UserPage, userId

        then:
        userName == 'UK User'
        userReports == ['report_1', 'report_2']

    }

    void 'shows user name and reports of a user with FRANCE locale'() {
        when: "A FRENCH user with 1 report exists"
        def remote = new RemoteControl()
        def userId = remote {
            def frUser = new User(name: 'FR User', locale: Locale.FRANCE).save()
            new Report(user: frUser, reportName: 'ercbeg_1').save()

            return frUser.id
        }

        and: "Go to this user page"
        to UserPage, userId

        then: "Report names should be 'translated'"
        userName == 'FR User'
        userReports == ['report_1']
    }

    @Ignore
    void 'adds a new report for a user with UK locale'() {
        //TODO
    }

    @Ignore
    void 'adds a new report for a user with FRANCE locale'() {
        //TODO
    }
}
