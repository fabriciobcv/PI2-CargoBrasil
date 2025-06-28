package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> get(@PathVariable Long id){
        Optional<Endereco> endereco = service.findById(id);


        return endereco.isPresent() ? ResponseEntity.ok(endereco.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Endereco> post(@RequestBody Endereco endereco){
        Endereco novoEndereco = service.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
    }
}
