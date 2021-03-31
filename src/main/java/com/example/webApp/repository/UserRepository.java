package com.example.webApp.repository;

import com.example.webApp.util.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Override
    Page<User> findAll(Pageable pageable);
}
