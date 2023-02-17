package com.attornatus.test.people.service.impl;


import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.repository.EnderecoRepository;
import com.attornatus.test.people.repository.PessoaRepository;
import com.attornatus.test.people.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaServiceimpl implements PessoaService {

    private final EnderecoServiceimpl enderecoServiceimpl;
    private final PessoaRepository pessoaRepository;

    @Override
    public Pessoa incluirPessoa(PessoaDTO pessoaDTO) {

        log.info("Nova Pessoa Está Sendo Criada");

        Pessoa novaPessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .dataDeNascimento(pessoaDTO.getDataDeNascimento())
                .enderecoPrincipal(enderecoServiceimpl.consultarEnderecoPorId(
                        pessoaDTO.getIdDoEnderecoPrincipal()
                ))
                .build();


        log.info("Nova Pessoa Foi Criada");

        return pessoaRepository.save(novaPessoa);

    }

    @Override
    public Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO) {

        log.info("Pessoa '%d' está sendo Atualizada", id);

        Pessoa pessoaAtualizada = consultarPessoaPorId(id);

        pessoaAtualizada.setNome(pessoaDTO.getNome());

        pessoaAtualizada.setDataDeNascimento(pessoaDTO.getDataDeNascimento());

        log.info("Pessoa com '%d' foi Atualizada", id);

        return pessoaRepository.save(pessoaAtualizada);
    }

    @Override
    public Pessoa atualizarEnderecoPrincipalDaPessoa(Long id, PessoaDTO pessoaDTO) {

//        log.info("O Endereco com '%d' está sendo Atualizado", id);
//
//        Pessoa pessoaComEnderecoPrincipalAtualizado = consultarPessoaPorId(id);
//
//        pessoaComEnderecoPrincipalAtualizado.setEnderecoPrincipal();
//
//        log.info("Endereco com '%d' foi Atualizada", id);
//
//        return pessoaRepository.save(pessoaComEnderecoPrincipalAtualizado);
        return null;
    }

    @Override
    public Pessoa consultarPessoaPorId(Long id) {

        log.info("Pessoa Com '%d' foi consultada", id);

        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O '%d' não foi encontrado".formatted(id)));

    }

    @Override
    public List<Pessoa> consultarTodasPessoas() {

        log.info("A Lista de Pessoas está sendo consultada");

        return pessoaRepository.findAll();
    }
}
