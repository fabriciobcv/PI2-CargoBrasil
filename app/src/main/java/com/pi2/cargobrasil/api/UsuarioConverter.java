package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Usuario;
import com.pi2.cargobrasil.domain.dto.UsuarioOutDTO;
import com.pi2.cargobrasil.service.ServicoService;
import com.pi2.cargobrasil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ServicoService servicoService;

    public UsuarioOutDTO toDTO(Usuario usuario){
        if(usuario == null){
            return null;
        }

        UsuarioOutDTO usuarioOutDTO = new UsuarioOutDTO();

        usuarioOutDTO.setId(usuario.getId());
        usuarioOutDTO.setNome(usuario.getNome());
        usuarioOutDTO.setEmail(usuario.getEmail());
        usuarioOutDTO.setTelefone(usuario.getTelefone());
        usuarioOutDTO.setCpf(usuario.getCpf());
        usuarioOutDTO.setSenha(usuario.getSenha());
        usuarioOutDTO.setTipo(usuario.getTipo());

        return usuarioOutDTO;

    }

    public Usuario toEntity( UsuarioOutDTO usuarioOutDTO){
        if(usuarioOutDTO == null){
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId(usuarioOutDTO.getId());
        usuario.setNome(usuarioOutDTO.getNome());
        usuario.setEmail(usuarioOutDTO.getEmail());
        usuario.setTelefone(usuarioOutDTO.getTelefone());
        usuario.setCpf(usuarioOutDTO.getCpf());
        usuario.setSenha(usuarioOutDTO.getSenha());
        usuario.setTipo(usuarioOutDTO.getTipo());
        usuario.setServicos(servicoService.findByRemetenteId(usuarioOutDTO.getId()));

        return usuario;

    }
}

