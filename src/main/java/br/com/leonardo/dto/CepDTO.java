package br.com.leonardo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairo;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}