package com.munchies.reviews.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException {

    public EmployeeAlreadyExistsException(Long id) {
        super(String.format("Employee(id=%d) already exists.", id));
    }

}
