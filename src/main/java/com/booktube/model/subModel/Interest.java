package com.booktube.model.subModel;

import com.booktube.model.User;

import javax.persistence.*;

@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    User user;

    /* to be continue */


}
