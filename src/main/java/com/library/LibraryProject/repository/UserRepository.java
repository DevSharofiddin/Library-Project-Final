package com.library.LibraryProject.repository;

import com.library.LibraryProject.model.Role;
import com.library.LibraryProject.model.Status;
import com.library.LibraryProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}