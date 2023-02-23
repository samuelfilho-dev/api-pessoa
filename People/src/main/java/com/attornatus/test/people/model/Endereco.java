package com.attornatus.test.people.model;


import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "CEP é Obrigatorio")
    @Size(max = 8, message = "Tamanho maximo de 8 Digitos")
    @Column(unique = true)
    private String CEP;

    @NotNull
    @NotEmpty(message = "Logradouro é Obrigatorio")
    @Size(max = 50, message = "Tamanho maximo de 50 Digitos")
    private String logradouro;


    private Integer numeroDaCasa;

    @NotNull
    @NotEmpty(message = "Cidade é Obrigatorio")
    @Size(max = 50, message = "Tamanho maximo de 50 Digitos")
    private String cidade;

    @ManyToOne
    private Pessoa pessoa;
}
