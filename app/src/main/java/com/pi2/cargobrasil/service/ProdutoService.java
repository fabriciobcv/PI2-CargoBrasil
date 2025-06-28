package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Produto;
import com.pi2.cargobrasil.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Optional<Produto> findById(Long id){
        return repository.findById(id);
    }
    public Produto save(Produto produto){
        return repository.save(produto);
    }
}
