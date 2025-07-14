package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.Status;
import com.pi2.cargobrasil.repository.ServicoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi2.cargobrasil.domain.Servico;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    
     public Optional<Servico> findById(Long id){
        return repository.findById(id);
    }

    public List<Servico> findByRemetenteId(Long id) {
         return repository.findAllByRemetenteId(id);
    }

    public Servico save(Servico servico){
        return repository.save(servico);
    }

    public Servico atualizarStatus(Long id, String status) {
         Optional<Servico> servicoAserAtualizado = repository.findById(id);

         if (servicoAserAtualizado.isPresent()){
             Servico servico = servicoAserAtualizado.get();
             servico.setStatus(status);

             if("APROVADO".equalsIgnoreCase(Status.APROVADO.name())){
                 String codigoRastreio = "CBR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
                 servico.setCodigoRastreio(codigoRastreio);
             }

             return repository.save(servico);
         }

         throw new NoSuchElementException("Serviço não encontrado com o ID:" + id);
    }
}
