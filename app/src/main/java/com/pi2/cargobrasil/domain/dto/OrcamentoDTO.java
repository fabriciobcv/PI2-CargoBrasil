package com.pi2.cargobrasil.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class OrcamentoDTO {
    private Long id;
    private double custoEmbalagem;
    private double taxaDesistencia;
    private double valor;
    private Integer prazo;
    private Long servicoId;
    private Long funcionarioOrcamentoId;

    public OrcamentoDTO() {
    }

    public OrcamentoDTO(Long id, double custoEmbalagem, double taxaDesistencia, double valor, Integer prazo, Long servicoId, Long funcionarioOrcamentoId) {
        this.id = id;
        this.custoEmbalagem = custoEmbalagem;
        this.taxaDesistencia = taxaDesistencia;
        this.valor = valor;
        this.prazo = prazo;
        this.servicoId = servicoId;
        this.funcionarioOrcamentoId = funcionarioOrcamentoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCustoEmbalagem() {
        return custoEmbalagem;
    }

    public void setCustoEmbalagem(double custoEmbalagem) {
        this.custoEmbalagem = custoEmbalagem;
    }

    public double getTaxaDesistencia() {
        return taxaDesistencia;
    }

    public void setTaxaDesistencia(double taxaDesistencia) {
        this.taxaDesistencia = taxaDesistencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Long getFuncionarioOrcamentoId() {
        return funcionarioOrcamentoId;
    }

    public void setFuncionarioOrcamentoId(Long funcionarioOrcamentoId) {
        this.funcionarioOrcamentoId = funcionarioOrcamentoId;
    }
}
