package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.FaseTransporte;
import com.pi2.cargobrasil.service.FaseTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/faseTransporte")
public class FaseTransporteController {
    @Autowired
    private FaseTransporteService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<FaseTransporte>> getFaseTransporte(@PathVariable Long id){
        List<FaseTransporte> fasesTransporte = service.findById(id);

        return !fasesTransporte.isEmpty() ? ResponseEntity.ok(fasesTransporte) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FaseTransporte> post(@RequestBody FaseTransporte faseTransporte){
        service.save(faseTransporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(faseTransporte);
    }

}
