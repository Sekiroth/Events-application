package com.afisha.user_service.service;

import com.afisha.user_service.controller.customExceptions.PasswordNotCorrectException;
import com.afisha.user_service.controller.utils.JwtTokenUtil;
import com.afisha.user_service.dao.api.IUserRepository;
import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.dto.user.UserLogin;
import com.afisha.user_service.dto.user.UserRegistration;
import com.afisha.user_service.service.api.IMappingService;
import com.afisha.user_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    IMappingService mappingService;
    @Autowired
    IUserRepository repository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public void create(@Valid UserCreate userCreate) {
        if(findByMail(userCreate.getMail()) != null) {
            throw new IllegalArgumentException("The user with such an email already exists");
        }
        User user = mappingService.create(userCreate);
        repository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User findByMail(String mail) {
        Optional<User> optional = repository.findByMail(mail);
        if (optional.isEmpty()) {
            return null;
        } else return optional.get();
    }

    @Override
    public User findByUuid(UUID uuid) {
        Optional<User> optional = repository.findById(uuid);
        if (optional.isEmpty()) {
            return null;
        } else return optional.get();
    }

    @Override
    public void update(UUID uuid, Integer dtUpdate, UserCreate userCreate) {
        if(findByUuid(uuid) == null) {
            throw new IllegalArgumentException("User not found");
        }
        User user = findByUuid(uuid);
        User update = mappingService.update(userCreate, user, dtUpdate);
        repository.save(update);
    }

    @Override
    public void register(@Valid UserRegistration userRegistration) {
        if (findByMail(userRegistration.getMail()) != null) {
            throw new IllegalArgumentException("Such user already exists");
        } else repository.save(mappingService.create(userRegistration));
    }

    @Override
    public String login(UserLogin userLogin) {
        UserDetails userDetails = findByMail(userLogin.getMail());
        if (!encoder.matches(userLogin.getPassword(),userDetails.getPassword())) {
            throw new PasswordNotCorrectException("Your password is not correct!");
        }
        return JwtTokenUtil.generateAccessToken(userDetails);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) {
        User user = findByMail(mail);
        if(user == null) {
            throw new UsernameNotFoundException("No such user found");
        }
        return findByMail(mail);
    }

    @Override
    public UserDisplay me() {
        UserDetails user = UserHolder.getUser();
        return mappingService.read(findByMail(user.getUsername()));
    }
}
