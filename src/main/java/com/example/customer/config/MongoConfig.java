package com.example.customer.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${port}")
    private String port;

    @Value("${dbname}")
    private String dbname;

    @Override
    protected String getDatabaseName(){
        return dbname;
    }

    @Override
    public MongoClient mongoClient(){
        return MongoClients.create();
    }
    @Override
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory, MappingMongoConverter mappingMongoConverter){
        return new MongoTemplate(mongoClient(),getDatabaseName());

    }
}
