package com.project.board.controller;

import com.project.board.dto.BoardDto;
import com.project.board.model.Board;
import com.project.board.repository.BoardRepository;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    // private final UserService userService;
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 게시글 목록
    @GetMapping("/api/posts")
    public List<Board> list() {
        return boardRepository.findAll();
        // 만약 리턴했는데 리스트가 아무것도 없다면 ??
        // null 체크 -> 예ㅊ외처리 필요
    }

    @GetMapping("/api/list/{id}")
    public Board getBoard(@PathVariable Long id) {
        return new Board(1L, "testuser", "post-title", "post-cont", LocalDate.now(), null);
    }

    @PostMapping("/api/list")
    public void post(@RequestBody BoardDto dto) {
        System.out.println(">>> " + dto);
    }

    @GetMapping("/api/post")
    public String wirte() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(@RequestBody @Valid BoardDto boardDto) {
        Board board = new Board(
                null,
                boardDto.getWriter(),
                boardDto.getTitle(),
                boardDto.getContent(),
                boardDto.getRDate(),
                boardDto.getMDate()
        );

        boardRepository.save(board);

        System.out.println(">>>> " + boardRepository.findById(1L).get());

        return "redirect:/";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        // return "board/update.html";
        return "";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        // boardService.savePost(boardDTO);

        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }

    //    // 게시글 검색
//    @GetMapping("/api/list/search")
//    public String search(@RequestParam(value="keyword") String keyword, Model model) {
//        List<BoardDto> boardList = boardService.searchPosts(keyword);
//        model.addAttribute("boardList", boardList);
//
//        // return "board/list.html";
//        return "board-list";
//    }

}
