package com.afisha.classifier.controller.advice;

import com.afisha.classifier.controller.exceptions.NoSuchClassifierFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String, Object>> handle(IllegalArgumentException e){
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());
        data.add(map);
        return data;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Map<String, Object>> handle(IllegalStateException e){
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());
        data.add(map);
        return data;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Map<String, Object>> handle(NoSuchClassifierFoundException e){
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());
        data.add(map);
        return data;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Map<String, Object>> handle(MethodArgumentNotValidException e){
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());
        data.add(map);
        return data;
    }

}