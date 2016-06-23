package com.data.miner.infrastructure.configuration;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import static java.util.Collections.singletonList;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.username}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return this.databaseName;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress(mongoHost, mongoPort)),
                singletonList(MongoCredential.createCredential(userName, databaseName, password.toCharArray())));
    }

    @Bean
    public DB db(Mongo mongo) {
        return mongo.getDB(this.databaseName);
    }
}
