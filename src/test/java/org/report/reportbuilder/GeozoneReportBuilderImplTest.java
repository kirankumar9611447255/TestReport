package org.report.reportbuilder;

import org.junit.jupiter.api.Test;
import org.report.bean.Customer;
import org.report.util.ReportPrinter;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class GeozoneReportBuilderImplTest {

    @Test
    void buildReport() {

        ReportPrinter printer = mock(ReportPrinter.class);

        String input = "2343225 , 2345 , us_east , RedTeam , ProjectApple , 3445\n" +
                "1223456 , 2345 , us_west , BlueTeam , ProjectBanana , 2211\n" +
                "3244332 , 2346 , us_west , BlueTeam , ProjectCarrot , 2221";

        List<Customer> customers= new ArrayList<>();
        Customer cust1= new Customer("2343225" , "2345" , "us_east" , "RedTeam" , "ProjectApple" , 3445);
        Customer cust2= new Customer("1223456" , "2345" , "us_west" , "BlueTeam" , "ProjectBanana" , 2211);
        Customer cust3= new Customer("2343225" , "2345" , "us_east" , "RedTeam" , "ProjectCarrot" , 3445);
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);

        ReportBuilder builder= new GeozoneReportBuilderImpl();
        builder.buildReport(customers);

        Map<String, Set<String>> expectedOutput = new HashMap<>();
        expectedOutput.put("2345", new HashSet<>(Arrays.asList("2343225", "1223456")));
        expectedOutput.put("2346", new HashSet<>(Collections.singletonList("3244332")));

        verify(printer, times(1)).printUniqueCustomerCount("geozone", expectedOutput);
       // verify(printer, times(1)).printAverageBuildDuration("geozone", expectedOutput);

    }
}