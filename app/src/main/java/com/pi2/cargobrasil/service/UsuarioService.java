package com.pi2.cargobrasil.service;

import com.pi2.cargobrasil.domain.Usuario;
import com.pi2.cargobrasil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return repository.save(usuario);
    }

    public Optional<Usuario> findByCpfAndSenha(String cpf, String senha){
        return repository.findByCpfAndSenha(cpf, senha);
    }
}
