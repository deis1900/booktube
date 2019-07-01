package com.booktube.repository;

import com.booktube.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    @Override
    <S extends User> S saveAndFlush(S s);

    @Override
    void delete(User user);
}
