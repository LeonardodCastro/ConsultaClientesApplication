package com.br.ConsultaClientesApplication.service;

import com.br.ConsultaClientesApplication.repository.ClienteRepository;
import com.br.ConsultaClientesApplication.repository.entity.Cliente;
import com.br.ConsultaClientesApplication.soDTO.CepDTO;
import com.br.ConsultaClientesApplication.soDTO.RequestDTO;
import com.br.ConsultaClientesApplication.soDTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoService {
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseDTO salvaNoBanco(RequestDTO requestDTO) {
        ViaCepService viaCepService = new ViaCepService();
        viaCepService.consultaViaCep(requestDTO);

        if (viaCepService != null) {
            Cliente cliente = new Cliente();
            CepDTO cepDTO = new CepDTO();

            cliente.setNome(requestDTO.getNome());
            cliente.setCep(requestDTO.getCep());
            cliente.setEndereco(viaCepService.cepDTO.getLogradouro());
            cliente.setCidade(viaCepService.cepDTO.getLocalidade());

            clienteRepository.save(cliente);

            ResponseDTO responseDTO = new ResponseDTO();

            responseDTO.setId(cliente.getId());
            responseDTO.setNome(cliente.getNome());
            responseDTO.setEndereco(cliente.getEndereco());
            responseDTO.setCidade(cliente.getCidade());

            return responseDTO;
        } else {
            System.out.println("Cep inválido!");
            return null;
        }
    }
}