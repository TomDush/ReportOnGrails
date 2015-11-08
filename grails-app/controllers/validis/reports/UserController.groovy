package validis.reports

import groovy.util.logging.Slf4j

@Slf4j
class UserController {

    def index() {
        // Get sorted users...
        def users = [
                new User().with {
                    name = "Dush"
                    reports = [new Report("report_1"), new Report("report_2"), new Report("report_3")]
                    it
                },
                new User().with {
                    name = "Tom"
                    reports = [new Report("report_4"), new Report("report_5"), new Report("report_6")]
                    it
                },
                new User().with {
                    name = "Naruto"
                    it
                }
        ]
        users.sort({u1, u2 -> u1.name.compareTo(u2.name)})

        return [users: users]
    }

}
