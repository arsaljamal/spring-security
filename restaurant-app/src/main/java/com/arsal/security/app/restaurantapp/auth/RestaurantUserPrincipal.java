package com.arsal.security.app.restaurantapp.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class RestaurantUserPrincipal implements UserDetails {

    private User user;
    private List<AuthGroup> authGroupList;

    public RestaurantUserPrincipal(User user, List<AuthGroup> authGroupList) {
        this.user = user;
        this.authGroupList = authGroupList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authGroupList == null) {
            return Collections.emptyList();
        }

        Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = new HashSet<>();
        authGroupList.forEach(authGroup -> {
            simpleGrantedAuthoritySet.add(new SimpleGrantedAuthority(authGroup.getAuthGroup()));
        });
        return simpleGrantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
