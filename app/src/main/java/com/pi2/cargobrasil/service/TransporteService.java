package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Transporte;
import com.pi2.cargobrasil.repository.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransporteService {

    @Autowired
    private TransporteRepository repository;

    public Transporte save(Transporte transporte){return repository.save(transporte);}

    public Optional<Transporte> findById(Long id){
        Transporte transporte = repository.getById(id);

        return Optional.of(transporte);
    }


}
