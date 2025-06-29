package com.pi2.cargobrasil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi2.cargobrasil.domain.Servico;
import com.pi2.cargobrasil.domain.dto.ServicoDTO;
import com.pi2.cargobrasil.service.EnderecoService;
import com.pi2.cargobrasil.service.ProdutoService;
import com.pi2.cargobrasil.service.UsuarioService;

@Component
public class ServicoConverter {
@Autowired
private UsuarioService usuarioService;

@Autowired
private EnderecoService enderecoService;

@Autowired
private ProdutoService produtoService;

public ServicoDTO toDto(Servico servico) {
    if (servico == null) {
        return null;
    }
    ServicoDTO dto = new ServicoDTO();
    dto.setId(servico.getId());
    dto.setProdutoId(servico.getProduto() != null ? servico.getProduto().getId() : null);
    dto.setPagamento(servico.getPagamento() != null ? servico.getPagamento() : null);
    dto.setStatus(servico.getStatus() != null ? servico.getStatus() : null);
    dto.setRemetenteId(servico.getRemetente() != null ? servico.getRemetente().getId() : null);
    dto.setDestinatarioId(servico.getDestinatario() != null ? servico.getDestinatario().getId() : null);
    dto.setEnderecoBuscaId(servico.getEnderecoBusca() != null ? servico.getEnderecoBusca().getId() : null);
    dto.setEnderecoEntregaId(servico.getEnderecoEntrega() != null ? servico.getEnderecoEntrega().getId() : null);
    return dto;
  
  }

public Servico toEntity(ServicoDTO dto) {
    if (dto == null) {
        return null;
    }
    Servico servico = new Servico();
    servico.setId(dto.getId());
    servico.setProduto(produtoService.findById(dto.getProdutoId()).get());
    servico.setPagamento(dto.getPagamento());
    servico.setStatus(dto.getStatus());
    servico.setRemetente(usuarioService.findById(dto.getRemetenteId()).get());
    servico.setDestinatario(usuarioService.findById(dto.getDestinatarioId()).get());
    servico.setEnderecoBusca(enderecoService.findById(dto.getEnderecoBuscaId()).get());
    servico.setEnderecoEntrega(enderecoService.findById(dto.getEnderecoEntregaId()).get());
    return servico;
  }
}
