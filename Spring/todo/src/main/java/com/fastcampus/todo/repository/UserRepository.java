package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}