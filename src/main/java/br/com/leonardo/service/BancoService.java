package br.com.leonardo.service;

//import br.com.leonardo.sodto.ErroDTO;

import br.com.leonardo.sodto.ErroDTO;
import br.com.leonardo.sodto.RequestDTO;
import br.com.leonardo.sodto.ResponseDTO;
import br.com.leonardo.repository.ClienteRepository;
import br.com.leonardo.repository.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ErroDTO erroDTO = new ErroDTO();

    public Object salvaNoBanco(RequestDTO requestDTO) throws Exception {
        ViaCepService viaCepService = new ViaCepService();
        viaCepService.consultaViaCep(requestDTO);
        ClienteEntity clienteEntity = new ClienteEntity();

        ResponseDTO responseDTO = new ResponseDTO();
        if (requestDTO.getCep().length() != 8) {

            erroDTO.setNome(requestDTO.getNome());
            erroDTO.setErro("CEP nāo consta na base de dados do correios.");
            return erroDTO;
        } else {
            clienteEntity.setNome(requestDTO.getNome());
            clienteEntity.setCep(requestDTO.getCep());
            clienteEntity.setEndereco(viaCepService.cepDTO.getLogradouro());
            clienteEntity.setCidade(viaCepService.cepDTO.getLocalidade());

            clienteRepository.save(clienteEntity);

            responseDTO.setId(clienteEntity.getId());
            responseDTO.setNome(clienteEntity.getNome());
            responseDTO.setEndereco(clienteEntity.getEndereco());
            responseDTO.setCidade(clienteEntity.getCidade());
            return responseDTO;
        }
    }
}