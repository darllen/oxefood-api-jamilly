package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    List<Cliente> consultarPorCpf(String cpf);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% ORDER BY c.nome")
    List<Cliente> findByNameContainingIgnoreCaseOrderByNomeAsc(String nome);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% AND c.cpf = :cpf")
    List<Cliente> consultarPorNomeECpf(String cpf, String nome);

  
}
