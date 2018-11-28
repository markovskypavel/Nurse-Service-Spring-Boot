package by.bsuir.markovsky.nursewebapp.constant;

public interface HTMLConstant {
    String HOME_PAGE = "home";
    String ABOUT_US_PAGE = "about";
    String SERVICE_PAGE = "service";
    String ADMIN_PAGE = "admin";
    String USER_PAGE = "user";
    String NURSE_PAGE = "nurse";

    //Authentication pages
    String LOGIN_PAGE = "authenticationpages/login";
    String REGISTRATION_PAGE = "authenticationpages/registration";
    String NURSE_REGISTRATION_PAGE = "authenticationpages/nurseregistration";

    //News pages
    String NEWS_PAGE_ADD = "editpages/news";
    String NEWS_PAGE_EDIT = "editpages/newsedit";

    //Service pages
    String SERVICE_PAGE_ADD = "editpages/service";
    String SERVICE_PAGE_EDIT = "editpages/serviceedit";

    //Error pages
    String DENIED_PAGE = "errorpages/403page";
    String NOT_FOUND_PAGE = "errorpages/404page";
    String ERROR_PAGE = "error";

    //Load fragments
    String HOME_FRAGMENT = "fragments/load/homeload :: homeload";
    String ADMIN_FRAGMENT = "fragments/load/adminload :: adminload";
    String USER_FRAGMENT = "fragments/load/userload :: userload";
    String NURSE_FRAGMENT = "fragments/load/nurseload :: nurseload";
    String SERVICE_FRAGMENT = "fragments/load/serviceload :: serviceload";
}
