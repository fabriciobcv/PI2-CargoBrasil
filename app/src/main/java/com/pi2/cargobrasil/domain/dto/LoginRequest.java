package com.pi2.cargobrasil.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
    private String cpf;
    private String senha;

    public LoginRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}