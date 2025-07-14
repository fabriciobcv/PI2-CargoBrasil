package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Servico;
import com.pi2.cargobrasil.domain.dto.ServicoDTO;
import com.pi2.cargobrasil.domain.dto.ServicoResponse;
import com.pi2.cargobrasil.service.ServicoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService service;

    @Autowired
    private ServicoConverter converter;

     @GetMapping("/{id}")
    public ResponseEntity<ServicoResponse> getServico(@PathVariable Long id) {
        Optional<Servico> servico = service.findById(id);
        return servico.isPresent() ? ResponseEntity.ok(converter.toResponse(servico.get())) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> post(@RequestBody ServicoDTO servicoDTO){
        Servico servico = converter.toEntity(servicoDTO);
        Servico servicoSalvo = service.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.toDto(servicoSalvo));
    }

    @PutMapping("/{id}/avaliar-orcamento")
    public ResponseEntity<String> avaliarOrcamento(@PathVariable Long id, @RequestParam String status){
         try {
             service.atualizarStatus(id, status);
             return ResponseEntity.ok("Status atualizado com sucesso");
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o status: " + e.getMessage());
         }
    }
}
