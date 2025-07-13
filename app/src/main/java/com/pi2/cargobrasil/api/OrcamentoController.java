package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.dto.OrcamentoDTO;
import com.pi2.cargobrasil.service.OrcamentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;

    @Autowired
    private OrcamentoConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<Orcamento> getOrcamento(@PathVariable Long id) {
        Optional<Orcamento> orcamento = service.findById(id);
        return orcamento.isPresent() ? ResponseEntity.ok(orcamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrcamentoDTO> post(@RequestBody OrcamentoDTO orcamentoDTO){
        Orcamento orcamento = converter.toEntity(orcamentoDTO);
        Orcamento novoOrcamento = service.save(orcamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.toDto(novoOrcamento));
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoDTO>> getOrcamentos(){
        List<Orcamento> orcamentos = service.list();
        List<OrcamentoDTO> orcamentosDTO = new ArrayList<>();

        for (Orcamento orcamento: orcamentos) {
            orcamentosDTO.add(converter.toDto(orcamento));
        }
        
        return !orcamentos.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(orcamentosDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/busca_por_servico/{servicoId}")
    public ResponseEntity<OrcamentoDTO> getOrcamentoById(@PathVariable Long servicoId){
        Optional<Orcamento> orcamento = service.findByServicoId(servicoId);
        OrcamentoDTO orcamentoDTO = converter.toDto(orcamento.get());

        return orcamento.isPresent() ? ResponseEntity.ok(orcamentoDTO) : ResponseEntity.notFound().build();
    }
}
