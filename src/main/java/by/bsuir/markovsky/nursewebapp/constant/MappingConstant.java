package by.bsuir.markovsky.nursewebapp.constant;

public interface MappingConstant {
    /*    localhost:(Port number) /project name/(request mapping at controller) /(request mapping at method)*/
    String HOME = "/";
    String ABOUT_US = "/about";
    String SERVICE = "/service";
    String ADMIN = "/admin";
    String USER = "/user";
    String NURSE = "/nurse";

    //Service routing
    String ADD_SERVICE = "/services/add";
    String EDIT_SERVICE = "/services/{id}/edit";
    //Service RESTful routing
    String DELETE_SERVICE = "/services/{id}/delete";
    String GET_SERVICE = "/services/{id}";
    String GET_ALL_SERVICES = "/services";
    String SUBSCRIBE = "/services/{serviceId}/users/{username}/subscribe";
    String UNSUBSCRIBE = "/services/{serviceId}/users/{username}/unsubscribe";

    //News routing
    String ADD_NEWS = "/news/add";
    String EDIT_NEWS = "/news/{id}/edit";
    //News RESTful routing
    String DELETE_NEWS = "/news/{id}/delete";
    String GET_NEWS = "/news/{id}";
    String GET_ALL_NEWS = "/news";

    //Authentication routing
    String LOGIN = "/login";
    String REGISTRATION = "/users/registration";
    String NURSE_REGISTRATION = "/users/nurseregistration";
    String LOGOUT = "/logout";

    //Error routing
    String DENIED = "/403";
    String NOT_FOUND = "/404";
    String ERROR = "/error";
    String ERROR_QUERY = "?error=true";
}
