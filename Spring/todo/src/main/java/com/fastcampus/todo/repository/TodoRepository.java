package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

// EntityManger <- Persistence Context