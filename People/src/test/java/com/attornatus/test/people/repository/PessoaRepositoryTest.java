package com.attornatus.test.people.repository;


import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Teste Da Entidade Pessoa")
@Slf4j
class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    @DisplayName("Teste de Salvar Pessoa Quando é Bem Sucedido")
    void save_persistirPessoa_QuandoBemsucedido(){

        Pessoa pessoaCriada = criarPessoa();

        Pessoa pessoaSalva = this.pessoaRepository.save(pessoaCriada);

        Assertions.assertThat(pessoaSalva).isNotNull();
        Assertions.assertThat(pessoaSalva.getId()).isNotNull();
        Assertions.assertThat(pessoaSalva.getNome()).isEqualTo(pessoaCriada.getNome());
        Assertions.assertThat(pessoaSalva.getDataDeNascimento()).isEqualTo(pessoaCriada.getDataDeNascimento());
        Assertions.assertThat(pessoaSalva.getEnderecos()).isEqualTo(pessoaCriada.getEnderecos());
        Assertions.assertThat(pessoaSalva.getEnderecoPrincipal()).isEqualTo(pessoaCriada.getEnderecoPrincipal());

    }

    @Test
    @DisplayName("Teste para atualização Pessoa Quando é Bem Sucedido")
    void save_atualizarPessoa_QuandoBemsucedido(){

        Pessoa pessoaCriada = criarPessoa();

        Pessoa pessoaSalva = this.pessoaRepository.save(pessoaCriada);

        pessoaSalva.setNome("Beatriz Silva");
        pessoaSalva.setDataDeNascimento(LocalDate.parse("2022-10-10"));

        Pessoa pessoaAtualizada = this.pessoaRepository.save(pessoaSalva);


        Assertions.assertThat(pessoaSalva).isNotNull();
        Assertions.assertThat(pessoaSalva.getId()).isNotNull();
        Assertions.assertThat(pessoaSalva.getNome()).isEqualTo(pessoaAtualizada.getNome());
        Assertions.assertThat(pessoaSalva.getDataDeNascimento()).isEqualTo(pessoaAtualizada.getDataDeNascimento());

    }

    @Test
    @DisplayName("Encontrar pelo id a Pessoa Quando é Bem Sucedido")
    void deletar_removerPessoa_QuandoBemsucedido(){

        Pessoa pessoaCriada = criarPessoa();

        Pessoa pessoaSalva = this.pessoaRepository.save(pessoaCriada);

        this.pessoaRepository.delete(pessoaSalva);

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(pessoaSalva.getId());

        Assertions.assertThat(pessoaOptional).isEmpty();

    }


    @Test
    @DisplayName("Teste para Encontrar Pessoa pelo id Quando é Bem Sucedido")
    void encontrarPeloId_retornarPessoa_QuandoBemsucedido(){

        Pessoa pessoaCriada = criarPessoa();

        Pessoa pessoaSalva = this.pessoaRepository.save(pessoaCriada);

        Long id = pessoaSalva.getId();

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(id);

        Assertions.assertThat(pessoaOptional)
                .isNotEmpty()
                .contains(pessoaSalva);

    }

    @Test
    @DisplayName("Teste para Encontrar Todas as Pessoas Quando é Bem Sucedido")
    void encontrarTodos_retornarPessoas_QuandoBemsucedido(){

        Pessoa pessoaCriada = criarPessoa();

        Pessoa pessoaSalva = this.pessoaRepository.save(pessoaCriada);

        List<Pessoa> pessoas = this.pessoaRepository.findAll();

        Assertions.assertThat(pessoas)
                .isNotEmpty()
                .contains(pessoaSalva);

    }

    @Test
    @DisplayName("Teste para Verificar se a Lista Pessoa está vazia Quando Ela não é Encontrada")
    void encontrarPeloId_retornarVazio_QuandoNaoEncontrado(){

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(90000000L);

        Assertions.assertThat(pessoaOptional).isEmpty();
    }

    @Test
    @DisplayName("Teste para Verificar se a Lista Pessoa está vazia Quando Ela não é Encontrada")
    void encontrarTodos_retornarVazio_QuandoNaoEncontrado(){

        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        pessoas.forEach(System.err::println);
        Assertions.assertThat(pessoas).isEmpty();
    }

    @Test
    @DisplayName("Teste Para Verificar ConstraintViolationException Quando está Vazio")
    void save_ThrowsConstraintViolationException_QuandoBemsucedido(){

        Pessoa pessoa = new Pessoa();

        Assertions.assertThatThrownBy(() -> this.pessoaRepository.save(pessoa))
                .isInstanceOf(ConstraintViolationException.class);

    }


    private Pessoa criarPessoa(){

        Endereco enderecoTeste = Endereco.builder()
                .CEP("68515000")
                .logradouro("Avenida Castelo Branco")
                .cidade("Sao Paulo")
                .build();

        Endereco enderecoTeste02 = Endereco.builder()
                .CEP("68515001")
                .logradouro("Avenida Castelo Branco")
                .cidade("Sao Paulo")
                .build();

        Endereco enderecoTeste03 = Endereco.builder()
                .CEP("68515002")
                .logradouro("Avenida Castelo Branco")
                .cidade("Sao Paulo")
                .build();

        List<Endereco> listaDeEnderecos = new ArrayList<>();
        listaDeEnderecos.add(enderecoTeste);
        listaDeEnderecos.add(enderecoTeste02);
        listaDeEnderecos.add(enderecoTeste03);

        return Pessoa.builder()
                .nome("Teste 01")
                .dataDeNascimento(LocalDate.parse("2023-02-23"))
                .enderecoPrincipal(enderecoTeste)
                .enderecos(listaDeEnderecos)
                .build();
    }

}