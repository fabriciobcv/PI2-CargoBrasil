package com.pi2.cargobrasil.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer largura;
    private Integer altura;
    private Integer comprimento;
    private Double peso;
    private String descricao;
    private Integer numero;

    public Produto(Integer largura, Integer altura, Integer comprimento, Double peso, String descricao, Integer numero) {
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.descricao = descricao;
        this.numero = numero;
    }

}
