package com.eventus.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebSecurity
@Configuration
public class EventusApiConfig {

    public DefaultSecurityFilterChain configurer(HttpSecurity http) throws Exception {

        http
                .addFilter((servletRequest, servletResponse, filterChain) -> filterChain.doFilter(servletRequest, servletResponse))
                .csrf(AbstractHttpConfigurer::disable)
                .anonymous(AbstractHttpConfigurer::disable);

        return http.build();

    }

}
