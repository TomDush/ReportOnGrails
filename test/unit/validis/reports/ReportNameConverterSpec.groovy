package validis.reports

import spock.lang.Specification
import spock.lang.Unroll

class ReportNameConverterSpec extends Specification {

    def reportNameConverter

    void setup() {
        reportNameConverter = new ReportNameConverter()
    }

    @Unroll
    void 'converts a report name based on a specific locale'() {
        expect:
        reportNameConverter.convert(reportName, locale) == convertedReportName

        where:
        reportName | locale        | convertedReportName
        'report_1' | Locale.UK     | 'report_1'
        'report_1' | Locale.FRANCE | 'ercbeg_1'
        'report_1' | Locale.US     | null
    }
}