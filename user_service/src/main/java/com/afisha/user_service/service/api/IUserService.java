package com.afisha.user_service.service.api;

import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.dto.user.UserLogin;
import com.afisha.user_service.dto.user.UserRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface IUserService extends UserDetailsService {
    void create (UserCreate userCreate); //for admins only
    Page<User> findAll(Pageable pageable);
    User findByUuid(UUID uuid);
    User findByMail(String mail);
    void update(UUID uuid, Integer dtUpdate, UserCreate userCreate);

    void register(UserRegistration userRegistration); //for users only
    String login(UserLogin userLogin);
    UserDisplay me();

}
