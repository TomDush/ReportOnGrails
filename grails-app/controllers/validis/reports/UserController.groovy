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

    /**
     * Get and translate report names for a given user
     */
    def getReports(long id) {
        def user = User.read id
        if(user != null) {
            render user.reportNames.collect(convertNames(user.locale)) as JSON
        } else {
            render([] as JSON)
        }
    }

    /** Generate a closure, which will convert report, for this locale */
    private Closure convertNames(Locale locale) {
        // French are so complex...
        if (Locale.FRANCE.equals(locale) || Locale.FRENCH.equals(locale)) {
            return {report -> [name: rot13(report.name)]}
        }

        // For anyone else, keep report as it was
        {it -> it}
    }

    /** Convert a string into ROT13 */
    def rot13 = { String s ->
        (s as List).collect { ch ->
            switch (ch) {
                case ('a'..'m') + ('A'..'M'):
                    return (((ch as char) + 13) as char)
                case ('n'..'z') + ('N'..'Z'):
                    return (((ch as char) - 13) as char)
                default:
                    return ch
            }
        }.inject ("") { string, ch -> string += ch}
    }
}
