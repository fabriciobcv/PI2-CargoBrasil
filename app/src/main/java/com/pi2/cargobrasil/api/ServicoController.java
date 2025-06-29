package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Servico;
import com.pi2.cargobrasil.domain.dto.ServicoDTO;
import com.pi2.cargobrasil.service.ServicoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService service;

    @Autowired
    private ServicoConverter converter;

     @GetMapping("/{id}")
    public ResponseEntity<Servico> getServico(Long id) {
        Optional<Servico> orcamento = service.findById(id);
        return orcamento.isPresent() ? ResponseEntity.ok(orcamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Servico> post(@RequestBody ServicoDTO servicoDTO){
        Servico servico = converter.toEntity(servicoDTO);
        Servico servicoSalvo = service.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoSalvo);
    }
}
