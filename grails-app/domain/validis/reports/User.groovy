package validis.reports

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

@EqualsAndHashCode(includes = ['name', 'locale'])
class User {

    @NotNull
    String name

    Locale locale

    List<Report> reports

    /** Derived method to get report names */
    def getReportNames() {
        reports.collect { r -> [name: r.reportName] }
    }

    static hasMany = [reports: Report]

    static constraints = {
        name blank: false
        locale nullable: false
    }

    static transients = ['reportNames']

    /**
     * Create a report and return it.
     * <p>
     * We assume we can't delete any report.
     **/
    def synchronized addReport() {
        def report = new Report(user: this, reportName: "report_${reports.size() + 1}")
        reports.add report

        return report.reportName
    }
}