package com.pi2.cargobrasil.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class ServicoDTO {

  private Long id;
  private Long produtoId;
  private String pagamento;
  private Long remetenteId;
  private Long destinatarioId;
  private Long enderecoBuscaId;
  private Long enderecoEntregaId;

    public ServicoDTO() {
      super();
    }

        public ServicoDTO(Long id, Long produtoId, String pagamento, String status,
                      Long remetenteId, Long destinatarioId,
                      Long enderecoBuscaId, Long enderecoEntregaId) {
        this.id = id;
        this.produtoId = produtoId;
        this.pagamento = pagamento;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.enderecoBuscaId = enderecoBuscaId;
        this.enderecoEntregaId = enderecoEntregaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
    public Long getRemetenteId() {
        return remetenteId;
    }

    public void setRemetenteId(Long remetenteId) {
        this.remetenteId = remetenteId;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public Long getEnderecoBuscaId() {
        return enderecoBuscaId;
    }

    public void setEnderecoBuscaId(Long enderecoBuscaId) {
        this.enderecoBuscaId = enderecoBuscaId;
    }

    public Long getEnderecoEntregaId() {
        return enderecoEntregaId;
    }

    public void setEnderecoEntregaId(Long enderecoEntregaId) {
        this.enderecoEntregaId = enderecoEntregaId;
    }
}
