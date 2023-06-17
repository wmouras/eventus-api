package com.eventus.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
public class EventusApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventusApiApplication.class, args);
    }
}
