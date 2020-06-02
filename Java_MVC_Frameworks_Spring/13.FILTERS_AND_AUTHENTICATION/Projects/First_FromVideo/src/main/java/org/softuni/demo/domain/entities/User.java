package org.softuni.demo.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    private String id;
    private String username;
    private String password;

    public User() {
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "org.hibernate.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return null;
    }

    @Override
    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return null;
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
}
