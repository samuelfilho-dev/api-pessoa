package com.attornatus.test.people.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetalis {
    protected String titulo;
    protected int status;
    protected String detalhes;
    protected String mensagemDesenvolvedor;
    protected LocalDateTime horario;
}
