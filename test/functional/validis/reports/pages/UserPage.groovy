package validis.reports.pages

import geb.Page

class UserPage extends Page {

    static url = "user/show/"

    static content = {
        userName { $('.user-name').text() }
        userReports { $('.report-list li')*.text() }
        addReportButton { $('.add-report') }
        reportCounter required: false, { $('.report-counter').text() }
    }

    @Override
    String convertToPath(Object... args) {
        args ? args*.toString().join('') : ''
    }
}
