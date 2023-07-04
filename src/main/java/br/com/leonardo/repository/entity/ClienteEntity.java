package br.com.leonardo.repository.entity;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Table
public class ClienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    @Column(name = "endereço") //TODO SEMPRE EVITE Ç OU ACENTUACAO
    private String endereco;
    private String cep;
    private String cidade;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    /**
     * USEI UM OPERADOR TERNARIO PARA RETORNAR O GET
     */
    public String getEndereco() {
        return endereco.length()==0?"SEM ENDEREÇO NO SITE DOS CORREIOS":endereco;
    }

    public String getCidade() {
        return cidade;
    }
}