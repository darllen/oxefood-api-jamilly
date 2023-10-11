package br.com.ifpe.oxefood.api.cliente.endereco;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoClienteService;

@RestController
@RequestMapping("/api/cliente/endereco")
@CrossOrigin
public class EnderecoClienteController {
    
    @Autowired
    private EnderecoClienteService enderecoClienteService;


    @PostMapping
    public ResponseEntity<EnderecoCliente> save(@RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente enderecoCliente = enderecoClienteService.save(request.build());
        return new ResponseEntity<EnderecoCliente>(enderecoCliente, HttpStatus.CREATED);
    }
 
    @GetMapping
    public List<EnderecoCliente> findAll() {

        return enderecoClienteService.findAll();
    }

    @GetMapping("/{id}")
    public ArrayList<EnderecoCliente> findById(@PathVariable ArrayList<Long> id) {

        return enderecoClienteService.findAllById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoCliente> update(@PathVariable("id") Long id, @RequestBody EnderecoClienteRequest request) {

        enderecoClienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        enderecoClienteService.delete(id);
        return ResponseEntity.ok().build();
    }


}
