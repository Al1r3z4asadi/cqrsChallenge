package com.example.toranj.Config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.toranj.DataAccess.Read", mongoTemplateRef = "mongoTemplate")
public class MongoDBConfiguration   {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUri))
                .build();

        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(String.valueOf(settings)));
    }
}
