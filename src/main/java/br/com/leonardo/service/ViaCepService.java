package br.com.leonardo.service;

import br.com.leonardo.sodto.CepDTO;
import br.com.leonardo.sodto.RequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepService {
    CepDTO cepDTO = new CepDTO();

    public CepDTO consultaViaCep(RequestDTO requestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepDTO> response = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", requestDTO.getCep()), CepDTO.class);
        cepDTO.setLocalidade(response.getBody().getLocalidade());
        cepDTO.setLogradouro(response.getBody().getLogradouro());
        return response.getBody();
    }
}