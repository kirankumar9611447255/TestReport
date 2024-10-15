package org.report.parsing;

import org.report.bean.Customer;
import java.util.ArrayList;
import java.util.List;

public class InputStringParser implements DataParser {
    @Override
    public List<Customer> parse(String input) {
        List<Customer> records = new ArrayList<>();
        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] parts = line.trim().split(",");
            String customerId = parts[0].trim();
            String contractId = parts[1].trim();
            String geozone = parts[2].trim();
            String buildDurations= parts[5].substring(0, parts[5].length()-1);
            int buildDuration = Integer.parseInt(buildDurations.trim());
            records.add(new Customer(customerId, contractId, geozone, buildDuration));
        }
        return records;
    }
}
