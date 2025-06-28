package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrcamentoRepository  extends JpaRepository<Orcamento, Long> {
    Optional<Orcamento> findByServico(Optional<Servico> servico);
}
