package com.attornatus.test.people.controller.dto;


import com.attornatus.test.people.model.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PessoaDTO {
    private String nome;
    private LocalDate dataDeNascimento;

    private List<Endereco> enderecos;
}
