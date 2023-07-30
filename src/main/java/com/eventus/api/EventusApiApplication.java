package com.eventus.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EventusApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventusApiApplication.class, args);
    }

}
