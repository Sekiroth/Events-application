package com.afisha.classifier.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig extends RestTemplate {
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
