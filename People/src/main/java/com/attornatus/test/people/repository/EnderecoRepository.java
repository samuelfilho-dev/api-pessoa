package com.attornatus.test.people.repository;

import com.attornatus.test.people.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByCEP(String CEP);


}
