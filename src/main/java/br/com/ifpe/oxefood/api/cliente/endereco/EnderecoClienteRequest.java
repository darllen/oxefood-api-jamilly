package br.com.ifpe.oxefood.api.cliente.endereco;

import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoClienteRequest {

    private Long idCliente;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
    

    public EnderecoCliente build() {
        return EnderecoCliente.builder()
            .rua(rua)
            .numero(numero)
            .bairro(bairro)
            .cep(cep)
            .cidade(cidade)
            .estado(estado)
            .complemento(complemento)
            .build();
   }

}
