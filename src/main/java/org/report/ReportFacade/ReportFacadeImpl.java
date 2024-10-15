package org.report.ReportFacade;

import org.report.bean.Customer;
import org.report.parsing.DataParser;
import org.report.parsing.InputStringParser;
import org.report.reportbuilder.ContractReportBuilderImpl;
import org.report.reportbuilder.GeozoneReportBuilderImpl;
import org.report.reportbuilder.ReportBuilder;
import org.report.validator.InputStringValidator;
import org.report.validator.InputStringValidatorImpl;

import java.util.List;

public class ReportFacadeImpl implements ReportFacade{

    private final DataParser parser;
    private final ReportBuilder contractReportBuilder;
    private final ReportBuilder geozoneReportBuilder;

    private final InputStringValidator inputStringValidator;

    public ReportFacadeImpl(DataParser parser, ReportBuilder contractReportBuilder, ReportBuilder geozoneReportBuilder,
            InputStringValidator inputStringValidator) {
        this.parser = parser;
        this.contractReportBuilder = contractReportBuilder;
        this.geozoneReportBuilder = geozoneReportBuilder;
        this.inputStringValidator = inputStringValidator;
    }

    public ReportFacadeImpl() {
        this.parser = new InputStringParser();
        this.contractReportBuilder = new ContractReportBuilderImpl();
        this.geozoneReportBuilder = new GeozoneReportBuilderImpl();
        this.inputStringValidator= new InputStringValidatorImpl();
    }



    // Unified method to generate all reports
    @Override
    public void generateReports(String input) throws Exception {
        List<Customer> records = parser.parse(input);
        inputStringValidator.validate(records);
        contractReportBuilder.buildReport(records);
        geozoneReportBuilder.buildReport(records);
    }
}
