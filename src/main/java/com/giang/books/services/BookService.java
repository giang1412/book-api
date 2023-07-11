package com.giang.books.services;


import com.giang.books.model.Book;
import com.giang.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public long save(Book book) {
        return bookRepository.save(book).getId();
    }
}
