package validis.reports

import grails.converters.JSON
import groovy.util.logging.Slf4j

@Slf4j
class UserController {

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

    def getReports(long id) {
        def user = User.read id
        render user.reports.collect { r -> [name: r.reportName] } as JSON
    }
}
