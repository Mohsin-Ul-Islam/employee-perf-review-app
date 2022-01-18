package com.munchies.reviews.exceptions;

public class EmployeeNameAlreadyExistsException extends RuntimeException {

    public EmployeeNameAlreadyExistsException(String name) {
        super(String.format("Employee(name=%s) already exists.", name));
    }

}
