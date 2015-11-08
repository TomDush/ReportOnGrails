package validis.reports

import grails.test.mixin.TestFor

@TestFor(User)
class UserBaseSpec extends EqualsHashCodeSpec {

    @Override
    protected createObjectToCompare() {
        new User(name: 'David', locale: Locale.UK)
    }

    @Override
    protected modifiedPropertiesIncludedInEqualsAndHashCode() {
        [name: 'Alex', locale: Locale.US]
    }
}