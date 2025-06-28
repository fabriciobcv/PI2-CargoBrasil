package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository repository;
    
}
