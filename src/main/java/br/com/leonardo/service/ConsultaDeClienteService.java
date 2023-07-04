package br.com.leonardo.service;

import br.com.leonardo.dto.ResponseDTO;
import br.com.leonardo.repository.ClienteRepository;
import br.com.leonardo.repository.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConsultaDeClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * vai até o banco de dados e realiza uma consulta por id
     * se nao existir, é devolvido uma exception
     */
    public ResponseEntity<?> consutaPorId(Long id) {
        Optional<ClienteEntity> byId = clienteRepository.findById(id);

        if (byId.isPresent()) {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setId(id);
            responseDTO.setNome(byId.get().getNome());
            responseDTO.setEndereco(byId.get().getEndereco());
            responseDTO.setCidade(byId.get().getCidade());
            return ResponseEntity.ok(responseDTO);
        }

        return ResponseEntity.notFound().build();
    }

}
