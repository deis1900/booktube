package com.booktube.service;

import com.booktube.model.Book;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BookService {

    Book finById(Long id);

    Set<Book> findAll();

    Boolean isPresent(Long id);

    Book saveAndUpdate(Book book);

    Boolean deleteBook(Book book);

    Set<Book> getSpecifiedBooks(String author, String nameBook, String year);
}
