package com.pi2.cargobrasil.domain;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Transporte {
    private Long id;
    private Long servicoId;
    private String dataColeta;
    private Long funcionarioTransporteId;

    @DynamoDbPartitionKey
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Long getFuncionarioTransporteId() {
        return funcionarioTransporteId;
    }

    public void setFuncionarioTransporteId(Long funcionarioTransporteId) {
        this.funcionarioTransporteId = funcionarioTransporteId;
    }
}
