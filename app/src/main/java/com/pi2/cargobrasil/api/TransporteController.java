package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Transporte;
import com.pi2.cargobrasil.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/transporte")
public class TransporteController {

    @Autowired
    private TransporteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Transporte> getTransporte(@PathVariable Long id){
        Optional<Transporte> transporte = service.findById(id);
        return transporte.isPresent() ? ResponseEntity.ok(transporte.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Transporte> post(@RequestBody Transporte transporte){
        service.save(transporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(transporte);
    }
}
