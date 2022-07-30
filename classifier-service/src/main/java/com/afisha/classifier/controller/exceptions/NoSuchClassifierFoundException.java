package com.afisha.classifier.controller.exceptions;

public class NoSuchClassifierFoundException extends IllegalArgumentException {

    public NoSuchClassifierFoundException(String msg) {
        super(msg);
    }
}