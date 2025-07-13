package com.pi2.cargobrasil.repository;

import com.pi2.cargobrasil.domain.Transporte;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Repository
public class TransporteRepository {

    private final DynamoDbTable<Transporte> table;


    public TransporteRepository(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
        this.table = enhancedClient.table("transporte", TableSchema.fromBean(Transporte.class));
    }

    public Transporte save(Transporte transporte){
        table.putItem(transporte);
        return transporte;
    }

    public Transporte getById(Long id){
        return table.getItem(Key.builder()
                .partitionValue(id)
                .build());
    }
}
