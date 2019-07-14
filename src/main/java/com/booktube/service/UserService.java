package com.booktube.service;

import com.booktube.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long aLong);

    <S extends User> S saveAndFlush(S s);

    void delete(User user);
}
