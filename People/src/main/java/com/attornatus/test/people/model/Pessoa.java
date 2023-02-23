package com.attornatus.test.people.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome é Obrigatorio")
    @NotNull
    @Size(max = 35, message = "Tamanho maximo é de 35 Digitos")
    private String nome;


    private LocalDate dataDeNascimento;

    @ManyToOne
    private Endereco enderecoPrincipal = getEnderecoPrincipal();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
}
