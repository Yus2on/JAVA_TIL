package com.project.board.repository;

import com.project.board.model.Board;
import com.project.board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // List<Board> findByName(String name);
}
