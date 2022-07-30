package com.afisha.user_service.dto.display;

import com.afisha.user_service.dao.entity.enums.Role;
import com.afisha.user_service.dao.entity.enums.Status;

import java.util.UUID;

public class UserDisplay {

    private final UUID uuid;
    private final Integer dtCreate;
    private final Integer dtUpdate;
    private final String mail;
    private final String nick;
    private final Role role;
    private final Status status;

    public UserDisplay(Builder builder) {
        this.uuid = builder.uuid;
        this.dtCreate = builder.dtCreate;
        this.dtUpdate = builder.dtUpdate;
        this.mail = builder.mail;
        this.nick = builder.nick;
        this.role = builder.role;
        this.status = builder.status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Integer getDtCreate() {
        return dtCreate;
    }

    public Integer getDtUpdate() {
        return dtUpdate;
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

    public static class Builder {

        private UUID uuid;
        private Integer dtCreate;
        private Integer dtUpdate;
        private String mail;
        private String nick;
        private Role role;
        private Status status;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setDtCreate(Integer dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public Builder setDtUpdate(Integer dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

        public Builder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder setNick(String nick) {
            this.nick = nick;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public UserDisplay build() {
            return new UserDisplay(this);
        }
    }
}
