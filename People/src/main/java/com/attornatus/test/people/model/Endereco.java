package com.attornatus.test.people.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



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

}
