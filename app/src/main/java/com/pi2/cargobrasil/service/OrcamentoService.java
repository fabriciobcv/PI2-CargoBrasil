package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.repository.OrcamentoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository repository;

     public Optional<Orcamento> findById(Long id){
        return repository.findById(id);
    }

    public Orcamento save(Orcamento orcamento){
        return repository.save(orcamento);
    }

    public List<Orcamento> list(){
         List<Orcamento> orcamentos = repository.findAll();
         return orcamentos;
    }
    
}
