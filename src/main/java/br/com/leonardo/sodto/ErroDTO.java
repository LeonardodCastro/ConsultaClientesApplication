package br.com.leonardo.sodto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroDTO {
    private String nome;
    private String erro;

    public ErroDTO funcaoerro(RequestDTO requestDTO){
        ErroDTO cagada = new ErroDTO();

        cagada.setNome(requestDTO.getNome());
        cagada.setErro("Cep invalido");
        return cagada;
    }
}