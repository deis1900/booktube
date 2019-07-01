package com.booktube.repository;

import com.booktube.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long id);

    @Override
    List<Book> findAll();

    @Override
    <S extends Book> S saveAndFlush(S s);

    @Override
    void delete(Book book);
}
