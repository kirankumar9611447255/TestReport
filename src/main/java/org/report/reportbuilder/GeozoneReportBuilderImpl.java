package org.report.reportbuilder;

import org.report.bean.Customer;
import org.report.util.ReportPrinter;

import java.util.*;

public class GeozoneReportBuilderImpl implements ReportBuilder{
    @Override
    public void buildReport(List<Customer> customerList) {
        Map<String, Set<String>> geozoneToCustomers = new HashMap<>();
        Map<String, List<Integer>> geozoneToDurations = new HashMap<>();

        for (Customer customer : customerList) {

            if (geozoneToCustomers.get(customer.getGeozone()) != null && geozoneToCustomers.get(customer.getGeozone()).contains(
                    customer.getCustomerId())) {
                geozoneToCustomers.get(customer.getGeozone()).remove(customer.getCustomerId());
            }else if (geozoneToCustomers.get(customer.getGeozone()) != null) {
                geozoneToCustomers.get(customer.getGeozone()).add(customer.getCustomerId());
            }else if(geozoneToCustomers.get(customer.getGeozone())== null){
                Set<String> temp= new HashSet<>();
                temp.add(customer.getCustomerId());
                geozoneToCustomers.put(customer.getGeozone(), temp);
            }

            geozoneToDurations
                    .computeIfAbsent(customer.getGeozone(), k -> new ArrayList<>())
                    .add(customer.getBuildDuration());
        }

        // Use ReportPrinter to print the reports
        ReportPrinter.printUniqueCustomerCount("geozone", geozoneToCustomers);
        ReportPrinter.printAverageBuildDuration(geozoneToDurations);
        ReportPrinter.printUniqueCustomerList("geozone", geozoneToCustomers);
    }
}
