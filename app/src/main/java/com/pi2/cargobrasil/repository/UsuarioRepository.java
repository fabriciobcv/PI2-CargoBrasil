package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpfAndSenha(String cpf, String senha);
}
