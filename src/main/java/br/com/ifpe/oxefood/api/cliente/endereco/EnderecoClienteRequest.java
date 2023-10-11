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
    
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String complemento;
    private String numero;


    public EnderecoCliente build() {

       return EnderecoCliente.builder()
               .rua(rua)
               .bairro(bairro)
               .cidade(cidade)
               .cep(cep)
               .uf(uf)
               .complemento(complemento)
               .build();
   }

}
