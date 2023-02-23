package com.attornatus.test.people.controller;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.service.impl.EnderecoServiceimpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/endereco")
@RequiredArgsConstructor
@Log4j2
public class EnderecoController {

    private final EnderecoServiceimpl enderecoServiceimpl;

    @GetMapping
    public ResponseEntity<Page<Endereco>> listarEnderecos(Pageable pageable) {

        log.info("Endpoint pegar todos Endereços");

        Page<Endereco> listTodosEnderecos = enderecoServiceimpl.listarEnderecos(pageable);

        return ResponseEntity.ok(listTodosEnderecos);
    }

    @GetMapping("/cep/{CEP}")
    public ResponseEntity<Endereco> buscarPorCEP(@PathVariable String CEP) {

        log.info("Endpoint Buscar Endereço pelo o CEP");

        Endereco consultarPorCEP = enderecoServiceimpl.consultarPorCEP(CEP);

        return ResponseEntity.ok(consultarPorCEP);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> consultarEnderecoPorId(@PathVariable Long id) {

        log.info("Endpoint Consultar Por id o Endereço");

        Endereco enderecoPorId = enderecoServiceimpl.consultarEnderecoPorId(id);

        return ResponseEntity.ok(enderecoPorId);
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {

        log.info("Endpoint Criar Endereço");

        Endereco criarEndereco = enderecoServiceimpl.criarEndereco(enderecoDTO);

        return new ResponseEntity<>(criarEndereco, HttpStatus.CREATED);
    }

}
