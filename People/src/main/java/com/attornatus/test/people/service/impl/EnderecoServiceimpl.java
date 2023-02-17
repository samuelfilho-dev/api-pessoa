package com.attornatus.test.people.service.impl;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.repository.EnderecoRepository;
import com.attornatus.test.people.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoServiceimpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Override
    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {

        log.info("Novo Endereco Está Sendo Criado");

        Endereco enderecoNovo = Endereco.builder()
                .CEP(enderecoDTO.getCEP())
                .logradouro(enderecoDTO.getLogradouro())
                .numeroDaCasa(enderecoDTO.getNumeroDaCasa())
                .cidade(enderecoDTO.getCidade())
                .build();

        log.info("Novo Foi Está Sendo Criado");

        return enderecoRepository.save(enderecoNovo);
    }

    @Override
    public List<Endereco> listarEnderecos() {

        log.info("Listando Todos Os Endereços");

        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarPorCEP(String CEP) {

        log.info("Pesquisar Usuario por CEP");

        return enderecoRepository.findByCEP(CEP);
    }

}
