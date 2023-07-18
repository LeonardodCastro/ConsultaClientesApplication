package br.com.leonardo.util;

import br.com.leonardo.dto.CepDTO;
import br.com.leonardo.dto.RequestDTO;
import br.com.leonardo.dto.ResponseDTO;
import br.com.leonardo.repository.entity.ClienteEntity;

/**
 * essa é uma classe utilitária
 * nela estao métodos estáticos que podem ser acessados de outros lugares do sistema
 */
public class CepUtil {

    private CepUtil() {
    }

    public static final String MSG_AO_FRONTEND = "O CEP NAO CONSTA NA BASE DOS CORREIOS .: ";

    /**
     * qualquer outra futura validação poderá ser alterada aqui no futuro
     */
    public static boolean isCepExisteNaBaseDosCorreios(String cep) {
        return cep.length() != 8;
    }

    public static ClienteEntity converterConsultaDosCorreiosEmEntidade(RequestDTO requestDTO, CepDTO consulta) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(requestDTO.getNome());
        clienteEntity.setCep(requestDTO.getCep());
        clienteEntity.setEndereco(consulta.getLogradouro());
        clienteEntity.setCidade(consulta.getLocalidade());
        return clienteEntity;
    }

    public static ResponseDTO converterEntidadeParaObjetoDeRetorno(ClienteEntity clienteEntity) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(clienteEntity.getId());
        responseDTO.setNome(clienteEntity.getNome());
        responseDTO.setEndereco(clienteEntity.getEndereco());
        responseDTO.setCidade(clienteEntity.getCidade());
        return responseDTO;
    }
}
