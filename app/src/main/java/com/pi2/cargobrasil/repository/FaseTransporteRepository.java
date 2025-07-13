package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.FaseTransporte;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

@Repository
public class FaseTransporteRepository {
    private final DynamoDbTable<FaseTransporte> table;

    public FaseTransporteRepository(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

        this.table = enhancedClient.table("faseTransporte", TableSchema.fromBean(FaseTransporte.class));
    }

    public FaseTransporte save(FaseTransporte faseTransporte){
        table.putItem(faseTransporte);
        return faseTransporte;
    }

    public List<FaseTransporte> findByFaseId(Long faseId) {
        QueryConditional queryConditional = QueryConditional
                .keyEqualTo(Key.builder().partitionValue(faseId).build());

        return table.query(r -> r.queryConditional(queryConditional))
                .items()
                .stream()
                .toList();
    }
}
