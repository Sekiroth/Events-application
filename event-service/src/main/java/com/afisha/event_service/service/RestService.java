package com.afisha.event_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    public String getJSON(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
