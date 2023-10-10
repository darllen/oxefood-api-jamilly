package br.com.ifpe.oxefood.api.produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private Long idCategoria;

   @NotNull(message = "O título é de preenchimento obrigatório")
   @NotBlank(message = "O título é de preenchimento obrigatório")
   private String titulo;

   @NotNull(message = "O codigo é de preenchimento obrigatório")
   @NotBlank(message = "O codigo é de preenchimento obrigatório")
   private String codigo;

   @NotNull(message = "O valor é de preenchimento obrigatório")
   @NotBlank(message = "O valor é de preenchimento obrigatório")
   private Double valorUnitario;

   private String descricao;
   private Integer tempoEntregaMin;
   private Integer tempoEntregaMax;

   public Produto build() {

      return Produto.builder()
            .titulo(titulo)
            .codigo(codigo)
            .descricao(descricao)
            .valorUnitario(valorUnitario)
            .tempoEntregaMin(tempoEntregaMin)
            .tempoEntregaMax(tempoEntregaMax)
            .build();
   }
}
