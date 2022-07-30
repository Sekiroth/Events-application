package com.afisha.user_service.service;

import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dao.entity.enums.Role;
import com.afisha.user_service.dao.entity.enums.Status;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.dto.user.UserCreate;
import com.afisha.user_service.dto.user.UserRegistration;
import com.afisha.user_service.service.api.IMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MappingService implements IMappingService {

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDisplay read(User user) {
        return UserDisplay.Builder.newInstance().
                setDtCreate(user.getDtCreate()).
                setDtUpdate(user.getDtUpdate()).
                setNick(user.getNick()).
                setMail(user.getMail()).
                setRole(user.getRole()).
                setStatus(user.getStatus()).
                setUuid(user.getUuid()).
                build();
    }

    @Override
    public User create(UserCreate userCreate) {
        return User.Builder.getInstance().
                setMail(userCreate.getMail()).
                setRole(userCreate.getRole()).
                setNick(userCreate.getNick()).
                setPassword(encoder.encode(userCreate.getPassword())).
                setStatus(userCreate.getStatus()).
                build();
    }

    @Override
    public User create(UserRegistration userRegistration) {
        return User.Builder.getInstance().
                setMail(userRegistration.getMail()).
                setRole(Role.USER).
                setNick(userRegistration.getNick()).
                setPassword(encoder.encode(userRegistration.getPassword())).
                setStatus(Status.WAITING_ACTIVATION).
                build();
    }

    @Override
    public User update(UserCreate userCreate, User user, Integer dtUpdate) {
        user.setDtUpdate(dtUpdate);
        user.setMail(userCreate.getMail());
        user.setNick(userCreate.getNick());
        user.setRole(userCreate.getRole());
        user.setStatus(userCreate.getStatus());
        user.setPassword(encoder.encode(userCreate.getPassword()));
        return user;
    }
}
