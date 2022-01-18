package com.munchies.reviews.advices;

import com.munchies.reviews.exceptions.EmployeeAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeAlreadyExistsAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    String handle(EmployeeAlreadyExistsException exc) {
        return exc.getMessage();
    }

}
