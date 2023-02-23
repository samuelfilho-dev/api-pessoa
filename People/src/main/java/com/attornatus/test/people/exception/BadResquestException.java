package com.attornatus.test.people.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResquestException extends RuntimeException{

    public BadResquestException(String message) {
        super(message);
    }
}
