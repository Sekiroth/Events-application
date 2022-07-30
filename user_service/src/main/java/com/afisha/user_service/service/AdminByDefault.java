package com.afisha.user_service.service;

import com.afisha.user_service.dao.api.IUserRepository;
import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dao.entity.enums.Role;
import com.afisha.user_service.dao.entity.enums.Status;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminByDefault implements CommandLineRunner {

    @Autowired
    private IUserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private IUserService service;

    @Override
    public void run(String... args) {
        if (service.findByMail("adminmail@gmail.com") == null) {
            repository.save(User.Builder.getInstance().
                    setStatus(Status.ACTIVATED).
                    setPassword(encoder.encode("StrongPass2$")).
                    setMail("adminmail@gmail.com").
                    setNick("admin").
                    setRole(Role.ADMIN).
                    build());
        }
    }
}