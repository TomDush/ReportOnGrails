package validis.reports

class Report {
    String reportName

    static belongsTo = [user: User]
    static constraints = { }

}
