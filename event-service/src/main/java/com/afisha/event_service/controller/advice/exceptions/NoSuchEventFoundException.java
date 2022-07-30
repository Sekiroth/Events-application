package com.afisha.event_service.controller.advice.exceptions;

public class NoSuchEventFoundException extends IllegalArgumentException {

    public NoSuchEventFoundException(String msg) {
        super(msg);
    }
}