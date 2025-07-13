package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.FaseTransporte;
import com.pi2.cargobrasil.repository.FaseTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseTransporteService {
    @Autowired
    private FaseTransporteRepository repository;

    public FaseTransporte save(FaseTransporte faseTransporte){return repository.save(faseTransporte);}

    public List<FaseTransporte> findById(Long id){
        List<FaseTransporte> fasesTransporte = repository.findByFaseId(id);
        return fasesTransporte;
    }
}
