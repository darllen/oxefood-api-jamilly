package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
//import br.com.ifpe.oxefood.util.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    
    private String nome;
    
    private String cpf;

    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;

    private Integer qEntregasRealizadas;

    private Double valorPorFrete;

    private Boolean statusAtivo;

    //private Endereco endereco;


    public Entregador build() {

       return Entregador.builder()
               .nome(nome)
               .cpf(cpf)
               .rg(rg)
               .dataNascimento(dataNascimento)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .qEntregasRealizadas(qEntregasRealizadas)
               .valorPorFrete(valorPorFrete)
               .statusAtivo(statusAtivo)
               .build();
   }
}
