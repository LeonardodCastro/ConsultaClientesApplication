package br.com.leonardo.service;

import br.com.leonardo.dto.CepDTO;
import br.com.leonardo.dto.RequestDTO;
import br.com.leonardo.dto.ResponseDTO;
import br.com.leonardo.exception.CepInexistenteException;
import br.com.leonardo.repository.ClienteRepository;
import br.com.leonardo.repository.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.leonardo.util.CepUtil.*;

@Service
public class CadastroDeClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ViaCepService viaCepService;

    public ResponseDTO pesquisaExistenciaNoSiteDosCorreios(RequestDTO requestDTO) throws CepInexistenteException {

        CepDTO consulta = viaCepService.consultaViaCep(requestDTO);

        ClienteEntity clienteEntity = converterConsultaDosCorreiosEmEntidade(requestDTO, consulta);
        clienteRepository.save(clienteEntity);

        return converterEntidadeParaObjetoDeRetorno(clienteEntity);
    }


}
