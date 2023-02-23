package com.attornatus.test.people.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadResquestExceptionDetails {
    private String titulo;
    private int status;
    private String detalhes;
    private String mensagemDesenvolvedor;
    private LocalDateTime horario;
}
