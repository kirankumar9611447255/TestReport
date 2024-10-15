package org.report.reportbuilder;

import org.report.bean.Customer;

import java.util.List;

public interface ReportBuilder {
    void buildReport(List<Customer> customers);
}
