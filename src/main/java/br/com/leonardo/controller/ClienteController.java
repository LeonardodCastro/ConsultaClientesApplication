package br.com.leonardo.controller;

import br.com.leonardo.dto.ErroDTO;
import br.com.leonardo.dto.RequestDTO;
import br.com.leonardo.exception.CepInexistenteException;
import br.com.leonardo.service.CadastroDeClienteService;
import br.com.leonardo.service.ConsultaDeClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    CadastroDeClienteService cadastroDeClienteService;

    @Autowired
    ConsultaDeClienteService consultaDeClienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
        return consultaDeClienteService.consutaPorId(id);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> salvarCliente(@RequestBody RequestDTO requestDTO) {
        try {
            return ResponseEntity.ok(cadastroDeClienteService.pesquisaExistenciaNoSiteDosCorreios(requestDTO));
        } catch (CepInexistenteException e) {
            ErroDTO erroDTO = new ErroDTO();
            erroDTO.setNome(requestDTO.getNome());
            erroDTO.setErro(e.getMessage());
            ResponseEntity.ok(erroDTO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
        }
    }
}
