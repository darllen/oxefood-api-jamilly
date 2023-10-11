package br.com.ifpe.oxefood.modelo.cliente.endereco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ClienteNaoEncontradoException;

@Service
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository repository;

    @Transactional
    public EnderecoCliente save(EnderecoCliente endereco) {

        endereco.setHabilitado(Boolean.TRUE);
        endereco.setVersao(1L);
        endereco.setDataCriacao(LocalDate.now());
        return repository.save(endereco);
    }

    public List<EnderecoCliente> findAll() {

        return repository.findAll();
    }

    public ArrayList<EnderecoCliente> findAllById(ArrayList<Long> arrayList) {

        ArrayList<EnderecoCliente> consulta = (ArrayList<EnderecoCliente>) repository.findAllById(arrayList);
  
       if (!consulta.isEmpty()) {
           return consulta;
       } else {
           throw new ClienteNaoEncontradoException("Cliente", arrayList);
       }
    }

    @Transactional
    public void update(Long id, EnderecoCliente enderecoALterado) {

        EnderecoCliente endereco = repository.findById(id).get();

        endereco.setRua(enderecoALterado.getRua());
        endereco.setBairro(enderecoALterado.getBairro());
        endereco.setCep(enderecoALterado.getCep());
        endereco.setCidade(enderecoALterado.getCidade());
        endereco.setNumero(enderecoALterado.getNumero());
        endereco.setUf(enderecoALterado.getUf());
        endereco.setComplemento(enderecoALterado.getComplemento());

        endereco.setVersao(endereco.getVersao() + 1);
        repository.save(endereco);
    }

    @Transactional
    public void delete(Long id) {

        EnderecoCliente endereco = repository.findById(id).get();
        
        endereco.setHabilitado(Boolean.FALSE);
        endereco.setVersao(endereco.getVersao() + 1);

        repository.save(endereco);
    }

    
}
