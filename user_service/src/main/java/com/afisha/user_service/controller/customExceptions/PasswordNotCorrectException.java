package com.afisha.user_service.controller.customExceptions;

import org.springframework.security.core.AuthenticationException;

public class PasswordNotCorrectException extends AuthenticationException {

    public PasswordNotCorrectException(String msg) {
        super(msg);
    }
}