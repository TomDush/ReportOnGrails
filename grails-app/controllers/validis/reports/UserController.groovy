package validis.reports

import grails.converters.JSON
import groovy.util.logging.Slf4j

@Slf4j
class UserController {

    ReportNameConverter reportNameConverter

    ReportGenerator reportGenerator

    def index() {
        def users = User.list(sort: 'name')

        return [users: users]
    }

    def show(long id) {
        def user = User.read(id)
        if (!user) {
            flash.message = "User with id ${id} doesn't exist."
            redirect(action: 'index')
        }

        render view: "show", model: ['user': user]
    }

    /**
     * Get and translate report names for a given user
     */
    def getReports(long id) {
        def user = User.read id
        if(user != null) {
            render user.reportNames.collect({ report -> [name: reportNameConverter.convert(report.name, user.locale)] }) as JSON
        } else {
            render([] as JSON)
        }
    }

    /** Add a report to this user and return report name as JSON in HTTP response */
    def addReport(User user) {
        def reportName = reportGenerator.addReport user
        render([name: reportName] as JSON)
    }

}
