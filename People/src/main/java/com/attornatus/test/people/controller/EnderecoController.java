package com.attornatus.test.people.controller;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.service.impl.EnderecoServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoServiceimpl enderecoServiceimpl;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        return new ResponseEntity<>(enderecoServiceimpl.listarEnderecos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        return new ResponseEntity<>(enderecoServiceimpl.criarEndereco(enderecoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/cep/{CEP}")
    public ResponseEntity<Endereco> buscarPorCEP(@PathVariable String CEP) {
        return new ResponseEntity<>(enderecoServiceimpl.buscarPorCEP(CEP), HttpStatus.OK);
    }

    @PutMapping("atualizar/endereco/{id}")
    public ResponseEntity<Pessoa> atualizarEnderecoPrincipalDaPessoa(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        return new ResponseEntity<>(enderecoServiceimpl.atualizarEnderecoPrincipalDaPessoa(id, enderecoDTO), HttpStatus.OK);
    }

}
