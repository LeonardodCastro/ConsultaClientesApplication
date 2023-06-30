package com.br.ConsultaClientesApplication.repository;

import com.br.ConsultaClientesApplication.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
