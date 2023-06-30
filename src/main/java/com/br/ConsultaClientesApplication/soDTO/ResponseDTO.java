package com.br.ConsultaClientesApplication.soDTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResponseDTO {
    private Long id;
    @Column
    private String nome;
    @Column
    private String endereco;
    @Column
    private String cidade;
}