package com.afisha.user_service.dao.entity;

import com.afisha.user_service.dao.entity.enums.Role;
import com.afisha.user_service.dao.entity.enums.Status;
import com.afisha.user_service.dto.BaseEssence;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users", schema = "user_service")
public class User implements UserDetails {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID uuid;
    @Column(nullable = false, updatable = false)
    private Integer dtCreate;
    @Column(nullable = false)
    private Integer dtUpdate;
    private String mail;
    private String nick;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String password;

    private User() {
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

    public void setDtUpdate(Integer dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Builder builder) {
        this.uuid = builder.uuid;
        this.dtCreate = builder.dtCreate;
        this.dtUpdate = builder.dtUpdate;
        this.mail = builder.mail;
        this.nick = builder.nick;
        this.role = builder.role;
        this.status = builder.status;
        this.password = builder.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class Builder {

        private final UUID uuid;
        private final Integer dtCreate;
        private final Integer dtUpdate;
        private String mail;
        private String nick;
        private Role role;
        private Status status;
        private String password;

        private Builder() {
            BaseEssence baseEssence = BaseEssence.getInstance();
            this.uuid = baseEssence.getUuid();
            this.dtCreate = baseEssence.getDtCreate();
            this.dtUpdate = baseEssence.getDtUpdate();
        }

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

        public User build() {
            return new User(this);
        }
    }
}
