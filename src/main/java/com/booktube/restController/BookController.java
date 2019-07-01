package com.booktube.restController;

import com.booktube.model.Book;
import com.booktube.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Book> getBook(@PathVariable Long bookID){
        //validation

        return new ResponseEntity<>(bookService.finById(bookID), HttpStatus.OK);
    }

    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Set<Book>> getListBooks(){
        return new ResponseEntity<Set<Book>>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{author}/{nameBook}/{year}/")
    ResponseEntity<Set<Book>> getTheSpecifiedBook(
            @PathVariable("author") String author,
            @PathVariable("nameBook") String nameBook,
            @PathVariable("year") String year) {
        return new ResponseEntity<Set<Book>> (bookService.getSpecifiedBooks(author, nameBook, year), HttpStatus.OK);
    }

    @PostMapping(value = "/upsert", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Book> upsert(Book book){
        if(bookService.isPresent(book.getProductId())){
            return new ResponseEntity<>(bookService.saveAndUpdate(book), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.saveAndUpdate(book), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(Book book){
        bookService.deleteBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }
}
