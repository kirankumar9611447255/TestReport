package org.report.parsing;


import org.report.bean.Customer;
import java.util.List;

public interface DataParser {
    List<Customer> parse(String input);
}
