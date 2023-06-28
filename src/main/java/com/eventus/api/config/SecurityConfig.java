//package com.eventus.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//               .authorizeHttpRequests(authorize -> authorize.anyRequest().anonymous())
//                .httpBasic(withDefaults())
//                .formLogin(withDefaults());
//        // @formatter:on
//        return http.build();
//    }
//
//    // @formatter:off
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    // @formatter:on
//
//}