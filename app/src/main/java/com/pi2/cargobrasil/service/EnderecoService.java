package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public Optional<Endereco> findById(Long id){
        return repository.findById(id);
    }
    public Endereco save(Endereco endereco){
        return repository.save(endereco);
    }
}
