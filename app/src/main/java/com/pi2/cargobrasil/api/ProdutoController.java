package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Produto;
import com.pi2.cargobrasil.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> get(@PathVariable Long id){
        Optional<Produto> produto = service.findById(id);


        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto produto){
        Produto novoProduto = service.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}
