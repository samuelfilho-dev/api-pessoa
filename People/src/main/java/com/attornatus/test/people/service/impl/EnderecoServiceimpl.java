package com.attornatus.test.people.service.impl;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.exception.BadResquestException;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.repository.EnderecoRepository;
import com.attornatus.test.people.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EnderecoServiceimpl implements EnderecoService {

    private final PessoaServiceimpl pessoaServiceimpl;
    private final EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {

        Pessoa pessoaPorId = pessoaServiceimpl.consultarPessoaPorId(enderecoDTO.getIdDaPessoa());

        Endereco novoEndereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numeroDaCasa(enderecoDTO.getNumeroDaCasa())
                .cidade(enderecoDTO.getCidade())
                .CEP(enderecoDTO.getCEP())
                .pessoa(pessoaPorId)
                .build();

       pessoaServiceimpl.atualizarEnderecoDaPessoa(novoEndereco, pessoaPorId);

        log.info("Novo Endereco Foi Criado");

        return enderecoRepository.save(novoEndereco);
    }

    @Override
    public Page<Endereco> listarEnderecos(Pageable pageable) {

        log.info("Listando Todos Os Endereços");

        return enderecoRepository.findAll(pageable);
    }

    @Override
    public Endereco consultarPorCEP(String CEP) {

        log.info("Pesquisando o CEP '{}'", CEP);

        return enderecoRepository.findByCEP(CEP);
    }

    @Override
    public Endereco consultarEnderecoPorId(Long id) {

        log.info("Pessoa Com '{}' foi consultada", id);

        return enderecoRepository.findById(id)
                .orElseThrow(() -> new BadResquestException("Endereco Não Encontrado"));
    }


}
