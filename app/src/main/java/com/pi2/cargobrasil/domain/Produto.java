package com.pi2.cargobrasil.domain;

import jakarta.persistence.*;


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

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
