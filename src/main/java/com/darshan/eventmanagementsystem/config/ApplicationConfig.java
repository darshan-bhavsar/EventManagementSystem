package com.darshan.eventmanagementsystem.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplateBuilder().build();
    }
    RestTemplate restTemplate = new RestTemplate();
}

