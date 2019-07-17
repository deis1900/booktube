package com.booktube.service;

import com.booktube.model.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    Book finById(Long id);

    Set<Book> findAll();

    Boolean isPresent(Long id);

    Book saveAndUpdate(Book book);

    Boolean deleteBook(Book book);

    List<Book> getSpecifiedBooks(String author, String nameBook, String year);

    
}
