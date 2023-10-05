package br.com.ifpe.oxefood.api.cliente.endereco;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoCliente;


@RestController
@RequestMapping("/api/produto/endereco-cliente")
@CrossOrigin
public class EnderecoClienteController {

    @Autowired
    private ClienteService enderecoClienteService;

    @PostMapping
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(Long clienteId, @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente enderecoCliente = enderecoClienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<EnderecoCliente>(enderecoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("id") Long id, @RequestBody EnderecoClienteRequest request) {

        enderecoClienteService.atualizarEnderecoCliente(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable Long id) {

        enderecoClienteService.removerEnderecoCliente(id);
        return ResponseEntity.ok().build();
    }
    
}
