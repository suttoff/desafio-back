package com.desafio.projectNT.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
    private static final String DEFAULT_RESPONSE = "Could not find id!";

    public NotFoundException() {
        super(DEFAULT_RESPONSE);
    }

    public NotFoundException(String s) {
        super(s);
    }
}
