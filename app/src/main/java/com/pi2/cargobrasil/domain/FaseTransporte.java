package com.pi2.cargobrasil.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.Map;

@DynamoDbBean
public class FaseTransporte {
    private Long servicoId;
    private Long faseNumero;
    private String status;
    private String meioTransporte;
    private String data;
    private Long funcionarioId;
    private Map<String, String> enderecoOrigem;
    private Map<String, String> enderecoDestino;

    @DynamoDbPartitionKey
    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    @DynamoDbSortKey
    public Long getFaseNumero() {
        return faseNumero;
    }

    public void setFaseNumero(Long faseNumero) {
        this.faseNumero = faseNumero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Map<String, String> getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(Map<String, String> enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Map<String, String> getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Map<String, String> enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
