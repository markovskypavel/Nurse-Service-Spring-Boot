package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({Exception.class})
    public ModelAndView handleRepositoryException() {
        return new ModelAndView(MappingConstant.MAIN + MappingConstant.ERROR_QUERY);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found")
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException() {
        return new ModelAndView(MappingConstant.MAIN);
    }

}
