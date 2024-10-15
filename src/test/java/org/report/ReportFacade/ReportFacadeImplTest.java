package org.report.ReportFacade;

import org.junit.jupiter.api.Test;
import org.report.bean.Customer;
import org.report.parsing.DataParser;
import org.report.parsing.InputStringParser;
import org.report.reportbuilder.ContractReportBuilderImpl;
import org.report.reportbuilder.GeozoneReportBuilderImpl;
import org.report.reportbuilder.ReportBuilder;
import org.report.validator.InputStringValidator;
import org.report.validator.InputStringValidatorImpl;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


class ReportFacadeImplTest {

    @Test
    void generateReports() throws Exception {
        String input = "2343225 , 2345 , us_east , RedTeam , ProjectApple , 3445s\n" +
                "1223456 , 2345 , us_west , BlueTeam , ProjectBanana , 2211s\n" +
                "3244332 , 2346 , us_west , BlueTeam , ProjectCarrot , 2221s";

        // Mock the builders and parser
        DataParser parser = mock(InputStringParser.class);
        InputStringValidator validator = mock(InputStringValidatorImpl.class);
        ReportBuilder contractReportBuilder = mock(ContractReportBuilderImpl.class);
        ReportBuilder geozoneReportBuilder = mock(GeozoneReportBuilderImpl.class);

        // Stub the parser to return records
        List<Customer> mockRecords = Arrays.asList(
                new Customer("2343225", "2345", "us_east", 3445),
                new Customer("1223456", "2345", "us_west", 2211),
                new Customer("3244332", "2346", "us_west", 2221)
        );
        when(parser.parse(input)).thenReturn(mockRecords);

        // Create the facade with mocks
        ReportFacadeImpl reportFacade = new ReportFacadeImpl(parser,contractReportBuilder,geozoneReportBuilder,validator);

        // Run the method under test
        reportFacade.generateReports(input);

        // Verify that both report builders were called
        verify(validator, times(1)).validate(mockRecords);
        verify(contractReportBuilder, times(1)).buildReport(mockRecords);
        verify(geozoneReportBuilder, times(1)).buildReport(mockRecords);
    }
}