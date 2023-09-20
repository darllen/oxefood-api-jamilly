package br.com.ifpe.oxefood.api.produto.categoria;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProdutoService;

@RestController
@RequestMapping("/api/produto/categoria")
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProduto = categoriaProdutoService.save(request.build());
        return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaProduto> findAll() {

        return categoriaProdutoService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaProduto findById(@PathVariable Long id) {

        return categoriaProdutoService.findById(id);
    }


}
