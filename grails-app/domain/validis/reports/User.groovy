package validis.reports

import javax.validation.constraints.NotNull

class User {

    @NotNull
    String name

    Locale locale

    List reports

    static hasMany = [reports: Report]

    static constraints = {
        name blank: false
        locale nullable: false
    }
}