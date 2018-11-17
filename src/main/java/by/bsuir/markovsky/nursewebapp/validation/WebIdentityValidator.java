package by.bsuir.markovsky.nursewebapp.validation;

import by.bsuir.markovsky.nursewebapp.constant.RegExConstant;
import by.bsuir.markovsky.nursewebapp.exception.ValidationException;
import by.bsuir.markovsky.nursewebapp.util.RegExValidatorUtil;

public class WebIdentityValidator {
    public static boolean isWebIdentityFormValid(String name, String surname, String age,
                                                 String username, String password, String email, String telephone, String address) throws ValidationException {
        if (name == null || surname == null || age == null || username == null || password == null || email == null || telephone == null || address == null) {
            throw new ValidationException();
        }
        if (!(RegExValidatorUtil.isValid(name, RegExConstant.NAME)
                && RegExValidatorUtil.isValid(surname, RegExConstant.SURNAME)
                && RegExValidatorUtil.isValid(age, RegExConstant.AGE)
                && RegExValidatorUtil.isValid(username, RegExConstant.USERNAME)
                && RegExValidatorUtil.isValid(password, RegExConstant.PASSWORD)
                && RegExValidatorUtil.isValid(email, RegExConstant.EMAIL)
                && RegExValidatorUtil.isValid(telephone, RegExConstant.TELEPHONE_ALTERNATIVE)
                && RegExValidatorUtil.isValid(address, RegExConstant.ADDRESS))) {
            throw new ValidationException();
        }
        return true;
    }
}
