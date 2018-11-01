package by.bsuir.markovsky.nursewebapp.validation;

import by.bsuir.markovsky.nursewebapp.constant.RegExConstant;
import by.bsuir.markovsky.nursewebapp.exception.ValidationException;
import by.bsuir.markovsky.nursewebapp.util.RegExValidatorUtil;

public class ArtistValidator {

    public static boolean isArtistFormValid(String name, String genre) throws ValidationException {
        if (name == null || genre == null) {
            throw new ValidationException();
        }
        if (!(RegExValidatorUtil.isValid(name, RegExConstant.UNIQUE_NAME)
                && RegExValidatorUtil.isValid(genre, RegExConstant.GENRE))) {
            throw new ValidationException();
        }
        return true;
    }

}
