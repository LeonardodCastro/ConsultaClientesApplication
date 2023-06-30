package com.br.ConsultaClientesApplication.clienteController;

import com.br.ConsultaClientesApplication.repository.ClienteRepository;
import com.br.ConsultaClientesApplication.repository.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteControllerGET {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscaPorId(@PathVariable("id") Long id) {
        return clienteRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
