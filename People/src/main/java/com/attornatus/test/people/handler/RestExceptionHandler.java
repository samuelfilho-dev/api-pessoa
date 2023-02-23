package com.attornatus.test.people.handler;

import com.attornatus.test.people.exception.BadResquestException;
import com.attornatus.test.people.exception.BadResquestExceptionDetails;
import com.attornatus.test.people.exception.ExceptionDetalis;
import com.attornatus.test.people.exception.ValidationExceptionDetalis;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadResquestException.class)
    public ResponseEntity<BadResquestExceptionDetails> handleBadResquestException(BadResquestException ex) {
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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ValidationExceptionDetalis> handlerDataIntegrityViolationException(
            DataIntegrityViolationException ex){

        return new ResponseEntity<>(
                ValidationExceptionDetalis.builder()
                        .horario(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception, Campo Invalido")
                        .detalhes("Por Favor, Confira o(s) campo(s)")
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        ExceptionDetalis exceptionDetalis = ExceptionDetalis.builder()
                .horario(LocalDateTime.now())
                .status(statusCode.value())
                .titulo(ex.getCause().getLocalizedMessage())
                .detalhes("Por Favor, Confira o(s) campo(s)")
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetalis, headers, statusCode);
    }

}
