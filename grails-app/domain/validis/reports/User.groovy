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
}