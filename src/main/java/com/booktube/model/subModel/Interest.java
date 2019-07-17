package com.booktube.model.subModel;

import com.booktube.model.User;

import javax.persistence.*;

@Embeddable
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToMany
    private User user;

    /* to be continue */


}
