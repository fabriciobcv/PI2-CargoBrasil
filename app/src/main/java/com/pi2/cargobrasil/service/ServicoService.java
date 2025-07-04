package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

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
}
