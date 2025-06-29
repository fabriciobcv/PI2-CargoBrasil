package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.dto.OrcamentoDTO;
import com.pi2.cargobrasil.service.OrcamentoService;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;

    @Autowired
    private OrcamentoConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<Orcamento> getOrcamento(Long id) {
        Optional<Orcamento> orcamento = service.findById(id);
        return orcamento.isPresent() ? ResponseEntity.ok(orcamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrcamentoDTO> post(@RequestBody OrcamentoDTO orcamentoDTO){
        Orcamento orcamento = converter.toEntity(orcamentoDTO);
        Orcamento novoOrcamento = service.save(orcamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.toDto(novoOrcamento));
    }
}
