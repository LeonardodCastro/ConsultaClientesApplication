package com.br.ConsultaClientesApplication.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereço")
    private String endereco;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
}