package com.attornatus.test.people.controller.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PessoaDTO {

    private String nome;
    private LocalDate dataDeNascimento;

}
