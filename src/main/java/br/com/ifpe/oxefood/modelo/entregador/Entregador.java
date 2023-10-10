package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

//import br.com.ifpe.oxefood.util.Endereco;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    
    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(nullable = true, length = 10)
    private String rg;

    @Column(name = "DT_NASC")
    private LocalDate dataNascimento;

    @Column(nullable = true, length = 20)
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Integer qEntregasRealizadas;

    @Column
    private Double valorPorFrete;

    @Column
    private Boolean statusAtivo;

    @Column
    private String rua;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String cep;

    @Column
    private String uf;

    @Column
    private String complemento;

    @Column
    private String numero;

    // private Endereco endereco;
}
