package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
}
