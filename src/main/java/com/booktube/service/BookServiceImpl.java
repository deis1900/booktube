package com.booktube.service;

import com.booktube.model.Book;
import com.booktube.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book finById(Long id)  {
        return bookRepository.getOne(id);
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Boolean isPresent(Long id) {
        return (finById(id) != null) ? Boolean.TRUE: Boolean.FALSE ;
    }

    @Override
    @Transactional
    public Book saveAndUpdate(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Boolean deleteBook(Book book) {
        bookRepository.delete(book);
        return isPresent(book.getProductId());
    }

    @Override
    public List<Book> getSpecifiedBooks(String author, String nameBook, String year) {
        return bookRepository.findBookByAuthorAndNameAndYear(author, nameBook, year);
    }
}
