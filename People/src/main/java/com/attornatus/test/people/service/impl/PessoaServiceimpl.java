package com.attornatus.test.people.service.impl;


import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.exception.BadResquestException;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.repository.PessoaRepository;
import com.attornatus.test.people.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PessoaServiceimpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Pessoa incluirPessoa(PessoaDTO pessoaDTO) {

        Pessoa novaPessoa = modelMapper.map(pessoaDTO, Pessoa.class);

        novaPessoa.setEnderecoPrincipal(pessoaDTO.getEnderecos().get(0));

        log.info("Nova Pessoa Está Sendo Criada ");

        return pessoaRepository.save(novaPessoa);

    }

    @Override
    public Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO) {

        Pessoa pessoaAtualizada = consultarPessoaPorId(id);
        pessoaAtualizada.setNome(pessoaDTO.getNome());
        pessoaAtualizada.setDataDeNascimento(pessoaDTO.getDataDeNascimento());

        log.info("Pessoa com id '{}' foi Atualizada", id);

        return pessoaRepository.save(pessoaAtualizada);
    }

    @Override
    public Pessoa consultarPessoaPorId(Long id) {

        log.info("Pessoa Com id '{}' foi consultada", id);

        return pessoaRepository.findById(id)
                .orElseThrow(() -> new BadResquestException ("Pessoa Não Encontrada"));

    }

    @Override
    public Page<Pessoa> consultarTodasPessoas(Pageable pageable) {

        log.info("Listando Todas As Pessoas");

        return pessoaRepository.findAll(pageable);
    }

    @Override
    public void deletarPessoa(Long id) {

        log.info("Deletando a Pessoa com id: '{}'", id);

        Pessoa pessoaDeletada = consultarPessoaPorId(id);

        pessoaRepository.delete(pessoaDeletada);

        log.info("Pessoa Deletada");
    }

    @Override
    public void atualizarEnderecoDaPessoa(Endereco endereco, Pessoa pessoaPorId) {

        log.info("Adicionando Endereço da Pessoa");

        List<Endereco> listaDeEnderecos = pessoaPorId.getEnderecos();
        listaDeEnderecos.add(endereco);
        pessoaPorId.setEnderecos(listaDeEnderecos);

        log.info("Endereço Adicionado Endereço da Pessoa");

        pessoaRepository.save(pessoaPorId);
    }
}
