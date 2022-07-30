package com.afisha.user_service.controller;

import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserLogin;
import com.afisha.user_service.dto.user.UserRegistration;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    IUserService service;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@Valid @RequestBody UserRegistration userRegistration) {
        service.register(userRegistration);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        return ResponseEntity.ok(service.login(userLogin));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me() {
        return ResponseEntity.ok(service.me());
    }
}
