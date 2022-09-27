package com.library.LibraryProject.service;

import com.library.LibraryProject.model.Author;
import com.library.LibraryProject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
