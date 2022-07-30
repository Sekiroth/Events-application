package com.afisha.user_service.controller;

import com.afisha.user_service.config.response.ResponseHandler;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.service.api.IUserService;
import com.afisha.user_service.service.pagination.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AdminController {

    @Autowired
    IUserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@Valid @RequestBody UserCreate userCreate) {
        service.create(userCreate);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "20") Integer size) {
        return ResponseHandler.generateResponse(new ResponsePage(service.findAll(PageRequest.of(page, size))));
    }

    @GetMapping("{uuid}")
    public ResponseEntity<?> findOne(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody UserCreate userCreate,
                       @PathVariable Integer dt_update,
                       @PathVariable UUID uuid) {
        service.update(uuid, dt_update, userCreate);
    }
}
