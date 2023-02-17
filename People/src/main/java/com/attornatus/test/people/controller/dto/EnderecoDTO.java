package com.attornatus.test.people.controller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EnderecoDTO {

    private String CEP;
    private String logradouro;
    private Integer numeroDaCasa;
    private String cidade;

}
