package com.br.ConsultaClientesApplication.clienteController;

import com.br.ConsultaClientesApplication.service.BancoService;
import com.br.ConsultaClientesApplication.soDTO.RequestDTO;
import com.br.ConsultaClientesApplication.soDTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente-cadastro")
public class ClienteControllerPOST {
    @Autowired
    BancoService bancoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO salvarCliente(@RequestBody RequestDTO requestDTO) {
        return bancoService.salvaNoBanco(requestDTO);
    }
}
