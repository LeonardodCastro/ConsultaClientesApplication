package br.com.leonardo.clientecontroller;

import br.com.leonardo.service.BancoService;
import br.com.leonardo.sodto.ErroDTO;
import br.com.leonardo.sodto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente-cadastro")
public class ClienteControllerPOST {
    @Autowired
    BancoService bancoService;
    @Autowired
    ErroDTO erroDTO;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object salvarCliente(@RequestBody RequestDTO requestDTO) {
        try {
            return bancoService.salvaNoBanco(requestDTO);
        } catch (Exception e) {
            return erroDTO.funcaoerro(requestDTO);
        }
    }
}