package com.attornatus.test.people.handler;

import com.attornatus.test.people.exception.BadResquestException;
import com.attornatus.test.people.exception.BadResquestExceptionDetails;
import com.attornatus.test.people.exception.ValidationExceptionDetalis;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadResquestException.class)
    public ResponseEntity<BadResquestExceptionDetails> handlerBadResquestException(BadResquestException ex) {
        return new ResponseEntity<>(
                BadResquestExceptionDetails.builder()
                        .horario(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception, Por Favor Verifique a documentação")
                        .detalhes(ex.getLocalizedMessage())
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationExceptionDetalis> handlerConstraintViolationException(
            ConstraintViolationException ex) {

        return new ResponseEntity<>(
                ValidationExceptionDetalis.builder()
                        .horario(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception, Campo Invalido")
                        .detalhes("Por Favor, Confira o(s) campo(s)")
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }



}
