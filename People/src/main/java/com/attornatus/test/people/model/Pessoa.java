package com.attornatus.test.people.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
  @Size(max = 35, message = "Tamanho maximo é de 35 Digitos")
  private String nome;

  @NotEmpty(message = "Data De Nascimento é Obrigatorio")
  @Size(max = 10, message = "Tamanho maximo é de 10 Digitos")
  private LocalDate dataDeNascimento;

  @OneToMany
  private List<Endereco> enderecos;

  @ManyToOne
  @JoinColumn(name = "endereco_principal_id")
  private Endereco enderecoPrincipal;
}
