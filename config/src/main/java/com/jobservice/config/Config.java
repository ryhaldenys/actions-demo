package com.jobservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.schema.registry.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.registry.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
// @EnableSchemaRegistryClient
public class Config {

    @Bean
    public SchemaRegistryClient schemaRegistryClient(
            @Value("${spring.cloud.stream.schema-registry-client.endpoint}") String endpoint) {
        ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
        client.setEndpoint(endpoint);
        return client;
    }
}
