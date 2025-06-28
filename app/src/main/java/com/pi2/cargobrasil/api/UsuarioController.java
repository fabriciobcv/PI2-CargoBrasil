package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Usuario;
import com.pi2.cargobrasil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        Optional<Usuario> usuario = service.findById(id);


        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        Usuario novoUsario = service.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsario);
    }
}
