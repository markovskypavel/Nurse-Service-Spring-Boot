package by.bsuir.markovsky.nursewebapp.validation;

import by.bsuir.markovsky.nursewebapp.constant.RegExConstant;
import by.bsuir.markovsky.nursewebapp.exception.ValidationException;
import by.bsuir.markovsky.nursewebapp.util.RegExValidatorUtil;

public class ActivityValidator {

    public static boolean isActivityFormValid(String name) throws ValidationException {
        if (name == null) {
            throw new ValidationException();
        }
        if (!(RegExValidatorUtil.isValid(name, RegExConstant.UNIQUE_NAME))) {
            throw new ValidationException();
        }
        return true;
    }

}
