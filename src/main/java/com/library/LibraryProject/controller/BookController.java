package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.Author;
import com.library.LibraryProject.model.Book;
import com.library.LibraryProject.service.AuthorService;
import com.library.LibraryProject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping("/book-post")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> bookPost(
            @RequestParam String book_name,
            @RequestParam int book_count,
            @RequestParam Long author_id) {

        Author author = authorService.findById(author_id);
        Book book = new Book();

            book.setBook_name(book_name);
            book.setBook_count(book_count);
            book.setAuthor(author);

        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/book-put")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> bookPut(
            @RequestParam Long book_id,
            @RequestParam String book_name,
            @RequestParam int book_count,
            @RequestParam Long author_id) {
        Author author = authorService.findById(author_id);
        Book book = new Book();

            book.setBook_id(book_id);
            book.setBook_name(book_name);
            book.setBook_count(book_count);
            book.setAuthor(author);

        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/book")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> bookGet() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> bookGetOne(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/book-del/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> bookDeleteOne(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
