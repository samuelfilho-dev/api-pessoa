package com.attornatus.test.people.service.impl;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.repository.EnderecoRepository;
import com.attornatus.test.people.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoServiceimpl implements EnderecoService {
    private final PessoaServiceimpl pessoaServiceimpl;
    private final EnderecoRepository enderecoRepository;

    @Override
    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {

        log.info("Novo Endereco Está Sendo Criado");

        Endereco enderecoNovo = Endereco.builder()
                .CEP(enderecoDTO.getCEP())
                .logradouro(enderecoDTO.getLogradouro())
                .numeroDaCasa(enderecoDTO.getNumeroDaCasa())
                .cidade(enderecoDTO.getCidade())
                .pessoa(pessoaServiceimpl.consultarPessoaPorId(enderecoDTO.getIdDaPessoa()))
                .build();


        log.info("Novo Endereco Foi Criado");

        return enderecoRepository.save(enderecoNovo);
    }

    @Override
    public List<Endereco> listarEnderecos() {

        log.info("Listando Todos Os Endereços");

        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarPorCEP(String CEP) {

        log.info("Pesquisar o Endereco por CEP");

        return enderecoRepository.findByCEP(CEP);
    }

    @Override
    public Endereco consultarEnderecoPorId(Long id) {

        log.info("Pessoa Com '%d' foi consultada", id);

        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco Não Encontrado"));
    }

    @Override
    public void deletarEndereco(Long id) {

        log.info("Deletando Endereco");

        Endereco enderecoDeletado = consultarEnderecoPorId(id);

        enderecoRepository.delete(enderecoDeletado);

        log.info("Pessoa Deletada");
    }

    @Override
    public Endereco atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {
        Endereco enderecoAtualizado = consultarEnderecoPorId(id);
        Pessoa pessoaPorId = pessoaServiceimpl.consultarPessoaPorId(enderecoDTO.getIdDaPessoa());

        enderecoAtualizado.setCEP(enderecoDTO.getCEP());
        enderecoAtualizado.setLogradouro(enderecoDTO.getLogradouro());
        enderecoAtualizado.setNumeroDaCasa(enderecoDTO.getNumeroDaCasa());
        enderecoAtualizado.setCidade(enderecoDTO.getCidade());
        enderecoAtualizado.setPessoa(pessoaPorId);

        return enderecoAtualizado;
    }

    @Override
    public Pessoa atualizarEnderecoPrincipalDaPessoa(Long id, EnderecoDTO enderecoDTO) {
        return null;
    }

}
