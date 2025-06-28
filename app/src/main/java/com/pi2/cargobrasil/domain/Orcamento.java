package com.pi2.cargobrasil.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Orcamento {
    private Long id;
    private Double custoEmbalagem;
    private Double taxaDesistencia;
    private Double valor;
    private Integer prazo;
    private Servico servico;
    private Usuario funcionario_orcamento_id;

    public Orcamento(Double custoEmbalagem, Double taxaDesistencia, Double valor, Integer prazo) {
        this.custoEmbalagem = custoEmbalagem;
        this.taxaDesistencia = taxaDesistencia;
        this.valor = valor;
        this.prazo = prazo;
    }
}
