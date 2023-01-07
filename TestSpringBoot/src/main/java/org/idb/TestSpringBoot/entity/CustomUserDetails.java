package org.idb.TestSpringBoot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private User u;

    public CustomUserDetails(User u) {
        this.u = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // user role-----> USER, ADMIN, SALES
        return null;
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getEmail();
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
    public boolean isEnabled() { // Our Task for 7-01-22
        return u.isEnabled();
    }
}
