package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;


@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());
        return repository.save(entregador);
    }

    public List<Entregador> findAll() {

        return repository.findAll();
    }

    public Entregador findById(Long id) {

        Optional<Entregador> consulta = repository.findById(id);
  
       if (consulta.isPresent()) {
           return consulta.get();
       } else {
           throw new EntidadeNaoEncontradaException("Cliente", id);
       }
    }

    @Transactional
    public void update(Long id, Entregador clienteAlterado) {

        Entregador entregador = repository.findById(id).get();

        entregador.setNome(clienteAlterado.getNome());
        entregador.setDataNascimento(clienteAlterado.getDataNascimento());
        entregador.setCpf(clienteAlterado.getCpf());
        entregador.setFoneCelular(clienteAlterado.getFoneCelular());
        entregador.setFoneFixo(clienteAlterado.getFoneFixo());

        entregador.setVersao(entregador.getVersao() + 1);
        repository.save(entregador);
    }

    @Transactional
    public void delete(Long id) {

        Entregador entregador = repository.findById(id).get();

        entregador.setHabilitado(Boolean.FALSE);
        entregador.setVersao(entregador.getVersao() + 1);

        repository.save(entregador);
    }
}
