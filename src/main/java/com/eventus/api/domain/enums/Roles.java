package com.eventus.api.domain.enums;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;

import java.lang.annotation.Annotation;
import java.util.Collection;


public enum Roles implements Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

}