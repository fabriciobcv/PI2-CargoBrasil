package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;
}
