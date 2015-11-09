package validis.reports

/** Report names converter, depending on locales */
class ReportNameConverter {

    /** Configure what method to use to translate report name */
    def translationConfig = [
            'fr_FR': rot13,
            'en_GB': { it }
    ]

    def convert(String name, Locale locale) {
        if (!translationConfig.containsKey(locale.toString())) {
            // Local not supported and no fallback locale
            return null
        }

        return translationConfig[locale.toString()](name)
    }

    /** Convert a string into ROT13 */
    def static rot13 = { String s ->
        (s as List).collect { ch ->
            switch (ch) {
                case ('a'..'m') + ('A'..'M'):
                    return (((ch as char) + 13) as char)
                case ('n'..'z') + ('N'..'Z'):
                    return (((ch as char) - 13) as char)
                default:
                    return ch
            }
        }.inject("") { string, ch -> string += ch }
    }
}
