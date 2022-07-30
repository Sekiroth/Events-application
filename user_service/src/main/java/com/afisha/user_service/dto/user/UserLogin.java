package com.afisha.user_service.dto.user;

import com.afisha.user_service.dao.entity.enums.Status;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class UserLogin {
    @Email
    @NotBlank
    private String mail;
    @NotBlank
    private String password;

    public UserLogin() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
