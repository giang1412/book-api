package com.giang.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private Double price;
    @NotNull
    private String img;


    @ManyToOne
    @NotNull
    @JoinColumn(name = "category_id")
    private Category category;
    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
