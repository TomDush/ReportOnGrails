package validis.reports

import org.springframework.stereotype.Service

/**
 * Generate new report for users
 */
@Service
class ReportGenerator {

    public static final int GENERATION_TIME = 3000

    /** Create a new report for this user and return its name */
    def addReport(User user) {
        // Wait 3s
        Thread.sleep(GENERATION_TIME)

        // Create report and save user (and implicitly the report)
        user.addReport()
    }
}
