package org.report.reportbuilder;

import org.report.bean.Customer;
import org.report.util.ReportPrinter;

import java.util.*;

public class ContractReportBuilderImpl implements ReportBuilder {

    @Override
    public void buildReport(List<Customer> customers) {
        Map<String, Set<String>> contractIdToCustomers = new HashMap<>();
        for (Customer customer : customers) {
            if (contractIdToCustomers.get(customer.getContractId()) != null && contractIdToCustomers.get(customer.getContractId()).contains(
                    customer.getCustomerId())) {
                contractIdToCustomers.get(customer.getContractId()).remove(customer.getCustomerId());
            }else if (contractIdToCustomers.get(customer.getContractId()) != null) {
                contractIdToCustomers.get(customer.getContractId()).add(customer.getCustomerId());
            }else if(contractIdToCustomers.get(customer.getContractId())== null){
                Set<String> temp= new HashSet<>();
                temp.add(customer.getCustomerId());
                contractIdToCustomers.put(customer.getContractId(), temp);
            }
        }
        // Use ReportPrinter to print the report
        ReportPrinter.printUniqueCustomerCount("contractId", contractIdToCustomers);
    }
}
