package com.attornatus.test.people.controller;

import com.attornatus.test.people.controller.dto.PessoaDTO;
import com.attornatus.test.people.model.Pessoa;
import com.attornatus.test.people.service.impl.PessoaServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaServiceimpl pessoaServiceimpl;


    @GetMapping
    public List<Pessoa> consultarTodasPessoas(){
        return pessoaServiceimpl.consultarTodasPessoas();
    }

    @GetMapping("/{id}")
    public Pessoa consultarPessoaPorId(@PathVariable Long id){
        return pessoaServiceimpl.consultarPessoaPorId(id);
    }

    @PostMapping
    public Pessoa incluirPessoa(@RequestBody PessoaDTO pessoaDTO){
        return pessoaServiceimpl.incluirPessoa(pessoaDTO);
    }

    @PutMapping("atualizar/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        return pessoaServiceimpl.atualizarPessoa(id,pessoaDTO);
    }

}
