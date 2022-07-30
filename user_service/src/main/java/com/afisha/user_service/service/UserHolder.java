package com.afisha.user_service.service;

import com.afisha.user_service.dao.entity.User;
import com.afisha.user_service.dto.display.UserDisplay;
import com.afisha.user_service.service.api.IMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    public static UserDetails getUser(){
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
