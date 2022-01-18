package com.munchies.reviews.exceptions;

import org.springframework.util.StringUtils;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String name, Long id) {
        super(String.format("%s(id=%d) does not exist.", StringUtils.capitalize(name), id));
    }

}
