package com.munchies.reviews.advices;

import com.munchies.reviews.exceptions.EmployeeNameAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeNameAlreadyExistsAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmployeeNameAlreadyExistsException.class)
    public String handle(EmployeeNameAlreadyExistsException exc) {
        return exc.getMessage();
    }

}
