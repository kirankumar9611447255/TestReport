package org.report.parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.report.bean.Customer;


import java.util.ArrayList;
import java.util.List;

class InputStringParserTest {

    @Test
    void parse() {
        String input = "2343225 , 2345 , us_east , RedTeam , ProjectApple , 3445s\n" +
                "1223456 , 2345 , us_west , BlueTeam , ProjectBanana , 2211s\n" +
                "3244332 , 2346 , us_west , BlueTeam , ProjectCarrot , 2221s";

        Customer customer1= new Customer("2343225","2345","us_east","RedTeam","ProjectApple",3445);
        InputStringParser inputStringParser= new InputStringParser();
        List<Customer> customerList= inputStringParser.parse(input);

        Assertions.assertEquals(3, customerList.size());
        Assertions.assertEquals(customerList.get(0).getCustomerId(),customer1.getCustomerId());
        Assertions.assertEquals(customerList.get(0).getContractId(),customer1.getContractId());
        Assertions.assertEquals(customerList.get(0).getGeozone(),customer1.getGeozone());
        Assertions.assertEquals(customerList.get(0).getBuildDuration(),customer1.getBuildDuration());
    }
}