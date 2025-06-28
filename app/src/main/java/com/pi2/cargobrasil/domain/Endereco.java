package com.pi2.cargobrasil.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    private Long id;
    private String estado;
    private String municipio;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;
    private String cep;

    public Endereco(String estado, String municipio, String bairro, String rua, Integer numero, String complemento, String cep) {
        super();
        this.estado = estado;
        this.municipio = municipio;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }}
