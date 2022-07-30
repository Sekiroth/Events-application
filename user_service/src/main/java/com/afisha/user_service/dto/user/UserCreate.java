package com.afisha.user_service.dto.user;

import com.afisha.user_service.dao.entity.enums.Role;
import com.afisha.user_service.dao.entity.enums.Status;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserCreate {

    @NotBlank
    @Email
    private String mail;
    @NotBlank
    private String nick;
    private Role role;
    private Status status;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$",
            message = "The password must contain at least least 1 uppercase letter, 1 special sign, 1 digit, and not be shorter than 8 symbols")
    private String password;

    private UserCreate() {
    }

    public String getMail() {
        return mail;
    }

    public String getNick() {
        return nick;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public UserCreate(Builder builder) {
        this.mail = builder.mail;
        this.nick = builder.nick;
        this.role = builder.role;
        this.status = builder.status;
        this.password = builder.password;
    }

    public static class Builder {
        private String mail;
        private String nick;
        private Role role;
        private Status status;
        private String password;

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder setMail(String mail) {
            this.mail = mail;
            return(this);
        }

        public Builder setNick(String nick) {
            this.nick = nick;
            return(this);
        }

        public Builder setRole(Role role) {
            this.role = role;
            return(this);
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return(this);
        }

        public Builder setPassword(String password) {
            this.password = password;
            return(this);
        }

        public UserCreate build() {
            return new UserCreate(this);
        }

    }
}
