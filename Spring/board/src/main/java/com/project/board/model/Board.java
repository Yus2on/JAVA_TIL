package com.project.board.model;

import com.project.board.dto.BoardDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {
    // 게시판 필요한거 : 글 작성자, 글제목, 글날짜, 글 내용, 등록일, 수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // postid, pid, 게시글id
    private String writer; // 작성자
    private String title; // 제목
    private String content; // 내용
    private LocalDate rDate; // 등록일
    private LocalDate mDate; // 수정일

    // 한 사용자 다수의 게시글

//    public static Board of(BoardDto boardDto) {
//        Board board = new Board();
//        board.setId(boardDto.getId());
//        board.setWriter(boardDto.getWriter());
//        board.setTitle(boardDto.getTitle());
//        board.setContent(boardDto.getContent());
//
//        return board;
//    }
}
