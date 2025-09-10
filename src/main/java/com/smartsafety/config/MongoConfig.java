package com.smartsafety.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient client) {
        return new MongoTemplate(client, getDatabaseName());
    }

    private String getDatabaseName() {
        // Parse database name from URI if present (simple fallback)
        if (mongoUri != null && mongoUri.contains("/")) {
            String[] parts = mongoUri.split("/");
            String last = parts[parts.length - 1];
            if (last.contains("?")) {
                return last.substring(0, last.indexOf("?"));
            }
            return last;
        }
        return "smartsafety";
    }
}
