package br.com.leonardo.service;

import br.com.leonardo.dto.CepDTO;
import br.com.leonardo.dto.RequestDTO;
import br.com.leonardo.exception.CepInexistenteException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static br.com.leonardo.util.CepUtil.MSG_AO_FRONTEND;
import static br.com.leonardo.util.CepUtil.isCepExisteNaBaseDosCorreios;

@Service
public class ViaCepService {

    String endPointDoCep = "https://viacep.com.br/ws/%s/json/";

    /**
     * método responsável por ir no site e buscar a informação
     * @throws CepInexistenteException -> exception personalizada!!!... é assim que se faz sempre
     */
    public CepDTO consultaViaCep(RequestDTO requestDTO) throws CepInexistenteException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepDTO> response;

        try{
            response = restTemplate.getForEntity(String.format(endPointDoCep, requestDTO.getCep()), CepDTO.class);
        }catch (Exception exception){
            throw new CepInexistenteException(MSG_AO_FRONTEND+requestDTO.getCep());
        }

        /**
         * perceba que o sinal "!" diz que deve ser diferente
         */
        if(!isCepExisteNaBaseDosCorreios(response.getBody().getCep())){
            throw new CepInexistenteException("O SITE DOS CORREIOS NAO RETORNOU ERRO, " +
                    "POREM NAO DEVOLVEU UMA CONSULTA VÁLIDA PARA O CEP.: "+requestDTO.getCep());
        }

        return response.getBody();
    }
}