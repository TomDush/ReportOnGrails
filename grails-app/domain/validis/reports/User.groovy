package validis.reports

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

@EqualsAndHashCode(includes = ['name', 'locale'])
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