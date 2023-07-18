package br.com.leonardo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDTO {
    private String nome;
    private String nomeDaMae;
    private String cep;
}
