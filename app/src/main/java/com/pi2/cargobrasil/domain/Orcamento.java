package com.pi2.cargobrasil.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double custoEmbalagem;
    private Double taxaDesistencia;
    private Double valor;
    private Integer prazo;
    @OneToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    @OneToOne
    @JoinColumn(name = "funcionario_orcamento_id")
    private Usuario funcionarOrcamentoId;

    public Orcamento(Double custoEmbalagem, Double taxaDesistencia, Double valor, Integer prazo) {
        this.custoEmbalagem = custoEmbalagem;
        this.taxaDesistencia = taxaDesistencia;
        this.valor = valor;
        this.prazo = prazo;
    }

    public Orcamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCustoEmbalagem() {
        return custoEmbalagem;
    }

    public void setCustoEmbalagem(Double custoEmbalagem) {
        this.custoEmbalagem = custoEmbalagem;
    }

    public Double getTaxaDesistencia() {
        return taxaDesistencia;
    }

    public void setTaxaDesistencia(Double taxaDesistencia) {
        this.taxaDesistencia = taxaDesistencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getFuncionarOrcamentoId() {
        return funcionarOrcamentoId;
    }

    public void setFuncionarOrcamentoId(Usuario funcionarOrcamentoId) {
        this.funcionarOrcamentoId = funcionarOrcamentoId;
    }
}
