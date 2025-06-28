package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
