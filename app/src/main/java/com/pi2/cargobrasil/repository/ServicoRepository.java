package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository  extends JpaRepository<Servico, Long> {
    Optional<Servico> findById(Long id);

    Optional<Servico> findByCodigoRastreio(String codigoRastreio);
    List<Servico> findAllByRemetenteId(Long id);

}
