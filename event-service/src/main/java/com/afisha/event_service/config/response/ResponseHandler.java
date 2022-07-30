package com.afisha.event_service.config.response;

import com.afisha.event_service.service.pagination.ResponsePage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(ResponsePage response) {
        Map<String, Object> map = new HashMap<>();
        map.put("number", response.getNumber());
        map.put("size", response.getSize());
        map.put("total_pages", response.getTotalPages());
        map.put("total_elements", response.getTotalElements());
        map.put("first", response.getFirst());
        map.put("number_of_elements", response.getNumberOfElements());
        map.put("last", response.getLast());
        map.put("content", response.getContent());

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
