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

        List<Endereco> listTodosEnderecos = enderecoServiceimpl.listarEnderecos();

        return ResponseEntity.ok(listTodosEnderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> consultarEnderecoPorId(@PathVariable Long id){

        Endereco enderecoPorId = enderecoServiceimpl.consultarEnderecoPorId(id);

        return ResponseEntity.ok(enderecoPorId);
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {

        Endereco criarEndereco = enderecoServiceimpl.criarEndereco(enderecoDTO);

        return new ResponseEntity<>(criarEndereco, HttpStatus.CREATED);
    }

    @GetMapping("/cep/{CEP}")
    public ResponseEntity<Endereco> buscarPorCEP(@PathVariable String CEP) {

        Endereco buscarPorCEP = enderecoServiceimpl.buscarPorCEP(CEP);

        return ResponseEntity.ok(buscarPorCEP);
    }

    @PutMapping("atualizar/endereco/{id}")
    public ResponseEntity<Endereco>atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO){

        Endereco atualizarEndereco = enderecoServiceimpl.atualizarEndereco(id, enderecoDTO);

        return ResponseEntity.ok(atualizarEndereco);
    }

    @PutMapping("atualizar/endereco/principal/{id}")
    public ResponseEntity<Pessoa> atualizarEnderecoPrincipalDaPessoa(
            @PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {

        Pessoa enderecoPrincipalDaPessoa = enderecoServiceimpl.atualizarEnderecoPrincipalDaPessoa(id, enderecoDTO);

        return ResponseEntity.ok(enderecoPrincipalDaPessoa);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){

        enderecoServiceimpl.deletarEndereco(id);

        return ResponseEntity.noContent().build();
    }

}
