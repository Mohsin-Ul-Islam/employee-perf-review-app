package com.munchies.reviews.advices;

import com.munchies.reviews.exceptions.FeedbackAlreadyAssignedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FeedbackAlreadyAssignedAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(FeedbackAlreadyAssignedException.class)
    String handle(FeedbackAlreadyAssignedException exc) {
        return exc.getMessage();
    }

}
