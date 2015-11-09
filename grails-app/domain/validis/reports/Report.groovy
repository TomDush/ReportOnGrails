package validis.reports

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = ['user', 'reportName'])
class Report {

    String reportName

    static belongsTo = [user: User]
    static constraints = {}

}
