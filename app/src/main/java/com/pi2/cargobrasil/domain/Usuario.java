package com.pi2.cargobrasil.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String tipo;

    @OneToMany(mappedBy = "remetente")
    private List<Servico> servicos;

    public Usuario(Long id, String nome, String email, String telefone, String cpf, String senha, String tipo) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.tipo = tipo;
    }
}
