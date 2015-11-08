package validis.reports

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
