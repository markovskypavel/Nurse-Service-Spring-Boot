package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = {Controller.class, RestController.class})
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ModelAndView(HTMLConstant.ERROR_PAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundRestException(HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ModelAndView(HTMLConstant.NOT_FOUND_PAGE);
    }

}
