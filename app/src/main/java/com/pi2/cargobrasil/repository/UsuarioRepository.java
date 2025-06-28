package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
