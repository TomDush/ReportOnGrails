package validis.reports

import javax.validation.constraints.NotNull

class User {

    @NotNull
    String name

    Locale locale

    List<Report> reports

    static hasMany = [reports: Report]

    static constraints = {
        name blank: false
        locale nullable: false
    }
}