package com.pi2.cargobrasil.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.Map;

@DynamoDbBean
public class FaseTransporte {
    private Long faseId;
    private Long transporteId;
    private String status;
    private String meioTransporte;
    private Long funcionarioLogisticaId;
    private Map<String, String> enderecoOrigem;
    private Map<String, String> enderecoDestino;

    @DynamoDbPartitionKey
    public Long getFaseId() {
        return faseId;
    }

    public void setFaseId(Long faseId) {
        this.faseId = faseId;
    }

    @DynamoDbSortKey
    public Long getTransporteId() {
        return transporteId;
    }

    public void setTransporteId(Long transporteId) {
        this.transporteId = transporteId;
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

    public Long getFuncionarioLogisticaId() {
        return funcionarioLogisticaId;
    }

    public void setFuncionarioLogisticaId(Long funcionarioLogisticaId) {
        this.funcionarioLogisticaId = funcionarioLogisticaId;
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
