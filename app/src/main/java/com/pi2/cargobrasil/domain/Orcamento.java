package com.pi2.cargobrasil.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
