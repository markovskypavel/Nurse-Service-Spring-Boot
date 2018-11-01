package by.bsuir.markovsky.nursewebapp.validation;

import by.bsuir.markovsky.nursewebapp.constant.RegExConstant;
import by.bsuir.markovsky.nursewebapp.exception.ValidationException;
import by.bsuir.markovsky.nursewebapp.util.RegExValidatorUtil;

public class PlaceValidator {

    public static boolean isPlaceFormValid(String address, String capacity) throws ValidationException {
        if (address == null || capacity == null) {
            throw new ValidationException();
        }
        if (!(RegExValidatorUtil.isValid(address, RegExConstant.ADDRESS)
                && RegExValidatorUtil.isValid(capacity, RegExConstant.CAPACITY))) {
            throw new ValidationException();
        }
        return true;
    }

}
