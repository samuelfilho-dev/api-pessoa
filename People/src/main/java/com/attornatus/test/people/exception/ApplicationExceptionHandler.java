package com.attornatus.test.people.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(ConstraintViolationException ex) {

        log.info("Entrando no Handler 'MethodArgumentNotValid' ");
        log.error(ex.getLocalizedMessage());
        ex.getStackTrace();

        return ResponseEntity.badRequest().build();
    }


}
