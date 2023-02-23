package com.attornatus.test.people.service;

import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Pessoa incluirPessoa(PessoaDTO pessoaDTO);
    Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO);
    Pessoa consultarPessoaPorId(Long id);
    Page<Pessoa> consultarTodasPessoas(Pageable pageable);
    void deletarPessoa(Long id);
    void atualizarEnderecoDaPessoa(Endereco endereco, Pessoa pessoaPorId);
}
