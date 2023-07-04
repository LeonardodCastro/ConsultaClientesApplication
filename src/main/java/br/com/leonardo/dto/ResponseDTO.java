package br.com.leonardo.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
}