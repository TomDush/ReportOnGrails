package validis.reports

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

@EqualsAndHashCode(includes = ['name', 'locale'])
class User {

    ReportNameConverter reportNameConverter

    @NotNull
    String name

    Locale locale

    List<Report> reports

    /** Derived method to get report names properly translated */
    def getReportNames() {
        reports.collect { r -> [name: reportNameConverter.convert(r.reportName, locale)] }
    }

    static hasMany = [reports: Report]

    static constraints = {
        name blank: false
        locale nullable: false
    }

    static transients = ['reportNames', 'reportNameConverter']

    /**
     * Create a report and return it.
     * <p>
     * We assume we can't delete any report.
     **/
    def synchronized addReport() {
        if (reports == null) {
            reports = []
        }

        def report = new Report(user: this, reportName: "report_${reports.size() + 1}")
        reports.add report

        return reportNameConverter.convert(report.reportName, locale)
    }
}