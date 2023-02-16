package com.attornatus.test.people.service;

import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa incluirPessoa(PessoaDTO pessoaDTO);
    Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO);
    Pessoa consultarPessoaPorId(Long id);
    List<Pessoa> consultarTodasPessoas();

}
