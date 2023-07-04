package br.com.leonardo.clientecontroller;

import br.com.leonardo.repository.ClienteRepository;
import br.com.leonardo.repository.entity.ClienteEntity;
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
    public ClienteEntity buscaPorId(@PathVariable("id") Long id) {
        return clienteRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
