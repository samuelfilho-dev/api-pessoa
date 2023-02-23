package com.attornatus.test.people.bean;

import com.attornatus.test.people.model.Endereco;
import com.attornatus.test.people.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Beans {

    @Bean
    public Pessoa pessoa(){
        return new Pessoa();
    }

    @Bean
    public Endereco endereco(){
        return new Endereco();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
