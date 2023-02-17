package com.attornatus.test.people.service;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco criarEndereco(EnderecoDTO enderecoDTO);

    List<Endereco> listarEnderecos();

    Endereco buscarPorCEP(String CEP);

    Endereco consultarEnderecoPorId(Long id);

}
