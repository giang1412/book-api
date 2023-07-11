package com.giang.books.controller;


import com.giang.books.model.Book;
import com.giang.books.repository.BookRepository;
import com.giang.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    /*---Add new book---*/
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        long id = bookService.save(book);
        return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
    }
}
