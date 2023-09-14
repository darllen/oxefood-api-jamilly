package br.com.ifpe.oxefood.util;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String complemento;
    
}
