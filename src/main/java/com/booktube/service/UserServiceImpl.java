package com.booktube.service;

import com.booktube.model.User;
import com.booktube.repository.UserRepository;
import com.booktube.util.exceptionHandler.LoginUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

//    @Override
//    public Optional<User> findById(User user) {
//        return userRepository.findById(user.getId()).orElseThrow(() ->
//                new LoginUserNotFoundException("User " + user.getLogin() + " was not found."));
//    }

    @Override
    public <S extends User> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
