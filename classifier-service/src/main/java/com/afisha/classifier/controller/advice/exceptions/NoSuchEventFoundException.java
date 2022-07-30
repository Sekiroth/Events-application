package com.afisha.event_service.controller.advice.exceptions;

public class NoSuchEventFoundException extends RuntimeException {

    private String message;

    public NoSuchEventFoundException() {}

    public NoSuchEventFoundException(String message) {
        super(message);
        this.message = message;
    }
}
