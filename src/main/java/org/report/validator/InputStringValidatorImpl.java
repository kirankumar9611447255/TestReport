package org.report.validator;

import org.report.bean.Customer;
import org.report.exception.InputNotProperException;

import java.util.List;

import static org.report.util.ErrorMessageConstant.*;

public class InputStringValidatorImpl implements InputStringValidator{

    @Override
    public void validate(List<Customer> customers) throws InputNotProperException {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == null) {
                throw new InputNotProperException(CUSTOMERID_IS_EMPTY);
            }

            if (customer.getContractId() == null) {
                throw new InputNotProperException(CONTRACT_IS_EMPTY);
            }

            if (customer.getGeozone() == null) {
                throw new InputNotProperException(GEOZONE_IS_EMPTY);
            }

            if (customer.getBuildDuration() == 0) {
                throw new InputNotProperException(TIMEBUILT_IS_EMPTY);
            }
        }
    }
}
