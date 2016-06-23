package com.data.miner.infrastructure.configuration;

import com.data.miner.utils.ObjectMerger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {
    @Bean
    public ObjectMerger objectMerger() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new ObjectMerger(objectMapper);
    }
}
