package com.booktube.model.subModel;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MANAGER;

    Role() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
