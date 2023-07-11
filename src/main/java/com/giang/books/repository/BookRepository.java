package com.giang.books.repository;

import com.giang.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface BookRepository extends JpaRepository<Book, Long> {
}
