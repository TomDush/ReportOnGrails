package validis.reports

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = ['id'])
class Report {
    String reportName

    Report() {
    }

    Report(String reportName) {
        this.reportName = reportName
    }

    static belongsTo = [user: User]
    static constraints = { }

}
