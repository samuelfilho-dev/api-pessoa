package com.attornatus.test.people.controller;

import com.attornatus.test.people.controller.dto.EnderecoDTO;
import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.service.impl.EnderecoServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoServiceimpl enderecoServiceimpl;

    @GetMapping
    public List<Endereco> listarEnderecos(){
        return enderecoServiceimpl.listarEnderecos();
    }

    @PostMapping
    public Endereco criarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoServiceimpl.criarEndereco(enderecoDTO);
    }

    @GetMapping("/cep/{CEP}")
    public Endereco buscarPorCEP(@PathVariable String CEP){
        return enderecoServiceimpl.buscarPorCEP(CEP);
    }

}
