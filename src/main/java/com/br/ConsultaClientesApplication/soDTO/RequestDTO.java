package com.br.ConsultaClientesApplication.soDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Data
@Setter
@Getter
public class RequestDTO {
    private String nome;
    @Column
    private String nome_da_mae;
    @Column
    private String cep;
    private String cidade;
}
