package com.attornatus.test.people.controller;

import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.service.impl.PessoaServiceimpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaServiceimpl pessoaServiceimpl;


    @GetMapping
    public ResponseEntity<Page<Pessoa>> consultarTodasPessoas(Pageable pageable) {

        Page<Pessoa> consultarTodasPessoas = pessoaServiceimpl.consultarTodasPessoas(pageable);

        return ResponseEntity.ok(consultarTodasPessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> consultarPessoaPorId(@PathVariable Long id) {

        Pessoa pessoaConsultada = pessoaServiceimpl.consultarPessoaPorId(id);

        return ResponseEntity.ok(pessoaConsultada);
    }

    @PostMapping
    public ResponseEntity<Pessoa> incluirPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {

        Pessoa incluirPessoa = pessoaServiceimpl.incluirPessoa(pessoaDTO);

        return new ResponseEntity<>(incluirPessoa, HttpStatus.CREATED);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {

        Pessoa atualizarPessoa = pessoaServiceimpl.atualizarPessoa(id, pessoaDTO);

        return ResponseEntity.ok(atualizarPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {

        pessoaServiceimpl.deletarPessoa(id);

        return ResponseEntity.noContent().build();
    }

}
