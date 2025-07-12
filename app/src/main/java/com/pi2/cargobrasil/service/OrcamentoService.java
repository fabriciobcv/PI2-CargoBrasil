package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Endereco;
import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.Servico;
import com.pi2.cargobrasil.repository.OrcamentoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository repository;

    @Autowired
    private ServicoService servicoService;

     public Optional<Orcamento> findById(Long id){
        return repository.findById(id);
    }

    public Orcamento save(Orcamento orcamento){
        return repository.save(orcamento);
    }

    public Optional<Orcamento> findByServicoId(Long servicoId){

        Optional<Servico> servico = servicoService.findById(servicoId);

        Optional<Orcamento> orcamento = repository.findByServico(servico);


        return orcamento;

    }

    public List<Orcamento> list(){
         List<Orcamento> orcamentos = repository.findAll();
         return orcamentos;
    }
    
}
