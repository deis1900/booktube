package com.booktube.model.subModel;

import javax.persistence.Entity;

@Entity
public enum Role
//        implements GrantedAuthority
{
    USER, ADMIN, MANAGER
}
