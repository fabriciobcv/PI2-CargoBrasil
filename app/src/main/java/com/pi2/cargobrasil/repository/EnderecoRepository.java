package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
}
