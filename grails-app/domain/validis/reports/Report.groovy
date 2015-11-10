package validis.reports

class Report {

    String reportName

    static belongsTo = [user: User]
    static constraints = {}

    // @EqualsAndHashCode doesn't work with business key: [user, reportName]

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Report)) return false

        Report report = (Report) o

        if (reportName != report.reportName) return false
        if (user != report.user) return false

        return true
    }

    int hashCode() {
        int result
        result = reportName.hashCode()
        result = 31 * result + user.hashCode()
        return result
    }
}
