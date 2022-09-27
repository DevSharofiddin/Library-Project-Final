package com.library.LibraryProject.controller;

import com.library.LibraryProject.JwtToken.SecurityUtil;
import com.library.LibraryProject.model.Book;
import com.library.LibraryProject.model.Role;
import com.library.LibraryProject.model.Status;
import com.library.LibraryProject.model.User;
import com.library.LibraryProject.service.BookService;
import com.library.LibraryProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final BookService bookService;

    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/user-post")
    public ResponseEntity<?> userPost(
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam Role role,
            @RequestParam Status status,
            @RequestParam Long book_id
    ) {
        Book book = bookService.findById(book_id);
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        user.setStatus(status);
        user.setBook_id(book);
        return ResponseEntity.ok(userService.userSave(user));
    }

    @PutMapping("/user-put")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> userPut(
            @RequestParam Long user_id,
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam Role role,
            @RequestParam Status status,
            @RequestParam Long book_id
    ) {
        Book book = bookService.findById(book_id);
        User user = new User();
        user.setUser_id(user_id);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        user.setStatus(status);
        user.setBook_id(book);
        return ResponseEntity.ok(userService.userSave(user));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> userGet() {
        return ResponseEntity.ok(userService.userFindAll());
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> userGetOne(@PathVariable Long id) {
        Optional<String> optional = SecurityUtil.getCurrentUserName();
        return ResponseEntity.ok(userService.userFindById(id));
    }

    @DeleteMapping("/user-del/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> userDeleteById(@PathVariable Long id) {
        userService.userDeleteOne(id);
        return ResponseEntity.ok("Deleted");
    }
}
