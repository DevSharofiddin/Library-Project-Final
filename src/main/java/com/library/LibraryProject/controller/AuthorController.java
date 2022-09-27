package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.Author;
import com.library.LibraryProject.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author-post")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> authorPost(@RequestParam String author_name) {
        Author author = new Author();
        author.setAuthor_name(author_name);
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/author-put")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> authorPut(@RequestParam Long author_id, @RequestParam String author_name) {
        Author author = new Author();
        author.setAuthor_id(author_id);
        author.setAuthor_name(author_name);
        return ResponseEntity.ok(authorService.save(author));
    }

    @GetMapping("/author")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> authorGet() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/author/{id}")
    @PreAuthorize("hasAuthority('read:write')")
    public ResponseEntity<?> authorGetOne(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("/author-del/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> authorDeleteOne(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
