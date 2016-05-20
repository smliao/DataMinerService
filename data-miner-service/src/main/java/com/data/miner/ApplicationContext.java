package com.data.miner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationContext {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationContext.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
