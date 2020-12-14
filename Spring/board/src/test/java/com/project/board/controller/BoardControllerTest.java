package com.project.board.controller;

import com.project.board.model.Board;
import com.project.board.repository.BoardRepository;
import com.project.board.service.BoardService;
import jdk.vm.ci.meta.ExceptionHandler;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardRepository boardRepository;
    @MockBean
    private BoardService boardService;

    @Test
    void list() throws Exception {
        when(boardRepository.findById(1L)).thenReturn(Optional.of(givenPost("testuser")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
                .andExpect(status().isOk());
    }

    private Board givenPost(String name) { // 테스트메소드 변경시켜가면서 테스트할 내용
        Board board = new Board();
        board.setId(1L);
        board.setWriter(name);
        // board.setTitle("new testTitle");
        // board.setContent("new testContent");
        // board.setRDate(new LocalDate(2021, 1, 22));
        return board;
    }

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .alwaysDo(print())
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void getBoard() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.writer").value("testuser"))
                .andExpect(jsonPath("$.title").value("post-title"));
                //.andExpect(jsonPath("$.rDate").value(LocalDate.now()))
                //.andExpect(jsonPath("$.mDate").value(null));
    }

}