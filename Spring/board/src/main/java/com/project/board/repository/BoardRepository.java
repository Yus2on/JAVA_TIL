package com.project.board.repository;

import com.project.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // Like search -> %{keyword}%
    // List<Board> findByTitleContaining(String keyword);
}
