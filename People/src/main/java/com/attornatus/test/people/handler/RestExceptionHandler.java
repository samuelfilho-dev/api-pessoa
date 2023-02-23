package com.attornatus.test.people.handler;

import com.attornatus.test.people.exception.BadResquestException;
import com.attornatus.test.people.exception.BadResquestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

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

}
