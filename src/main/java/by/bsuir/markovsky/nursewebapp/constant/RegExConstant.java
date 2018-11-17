package by.bsuir.markovsky.nursewebapp.constant;

public interface RegExConstant {
    //Identity
    String SURNAME = "^$|^[А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1}$";
    String NAME = "^[А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1}$"; //Not empty
    String AGE = "^$|^[1-9][0-9]{0,2}$";

    //Nurse
    String EXPERIENCE = "^[1-9][0-9]{0,2}$"; //Not empty

    //WebIdentity
    String USERNAME = "^[A-Za-z][A-Za-z0-9_]{2,19}$"; //Not empty
    String PASSWORD = "^[A-Za-z0-9]{3,20}$"; //Not empty
    String EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"; //Not empty
    String TELEPHONE = "^$|^((17)|(29)|(33)|(44)|(25))([1-9][0-9]{6})$";
    String TELEPHONE_ALTERNATIVE = "^$|^(80|\\+375)[\\s|-]?(17|29|33|44|25)[\\s|-]?([\\s|-]?\\d{2,3})+$";
    String ADDRESS = "^((ул\\.\\s)|(просп\\.\\s)|(пер\\.\\s)|(бульвар\\s))([А-ЯЁ][а-яё]{0,20}([\\-][А-ЯЁ][а-яё]{0,20}){0,1})(\\s)([1-9][0-9]{0,3}(\\-[1-5]){0,1})$"; //Not empty

    String UNIQUE_NAME = "^([А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1})|([A-Z][a-z]{0,9}([\\-][A-Z][a-z]{0,9}){0,1})$"; //Not empty
}
