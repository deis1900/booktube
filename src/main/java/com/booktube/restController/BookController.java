package com.booktube.restController;

import com.booktube.model.Book;
import com.booktube.service.BookService;
import com.booktube.util.exceptionHandler.UserIdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable Long bookID){
        //validation

        return new ResponseEntity<>(bookService.finById(bookID), HttpStatus.OK);
    }

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Book>> getListBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{author}/{nameBook}/{year}/")
    public ResponseEntity<List<Book>> getTheSpecifiedBook(
            @PathVariable("author") String author,
            @PathVariable("nameBook") String nameBook,
            @PathVariable("year") String year) {
        return new ResponseEntity<> (bookService.getSpecifiedBooks(author, nameBook, year), HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> save(Book book){
        return new ResponseEntity<>(bookService.saveAndUpdate(book), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Book> update(@PathVariable("id") Long id,  Book book) {
        if (bookService.isPresent(id)) {
            return new ResponseEntity<>(bookService.saveAndUpdate(book), HttpStatus.OK);
        }
        else throw new UserIdMismatchException();
    }

    @DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(Book book){
        bookService.deleteBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @GetMapping("/{id}/videos")
//    ResponseEntity<>
}
