package com.attornatus.test.people.service;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {

    Endereco criarEndereco(EnderecoDTO enderecoDTO);

    Page<Endereco> listarEnderecos(Pageable pageable);

    Endereco consultarPorCEP(String CEP);

    Endereco consultarEnderecoPorId(Long id);

}
