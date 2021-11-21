package com.project.schedule.security;

import com.project.schedule.persistence.repository.entity.Role;
import com.project.schedule.persistence.repository.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final boolean active;
    private final Set<GrantedAuthority> roles;


    public CustomUserDetails(final User user) {

        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.roles = new HashSet<>();

        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return active;
    }

}