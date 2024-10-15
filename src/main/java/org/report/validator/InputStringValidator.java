package org.report.validator;

import org.report.bean.Customer;
import org.report.exception.InputNotProperException;

import java.util.List;

public interface InputStringValidator {

    void validate(List<Customer> customers) throws InputNotProperException;
}
