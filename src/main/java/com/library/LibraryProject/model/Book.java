package com.library.LibraryProject.model;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @NotNull
    private String book_name;

    @NotNull
    private int book_count;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author_id;

    public Book() {}

    public Long getBook_id() {
        return book_id;
    }
    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public int getBook_count() {
        return book_count;
    }
    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }
    public Author getAuthor() {
        return author_id;
    }
    public void setAuthor(Author author) {
        this.author_id = author;
    }
}
