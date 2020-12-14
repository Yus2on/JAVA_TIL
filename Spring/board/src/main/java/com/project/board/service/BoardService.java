package com.project.board.service;


import com.project.board.dto.BoardDto;
import com.project.board.model.Board;
import com.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    private BoardDto convertEntityToDto(Board boardEntity) {
        return BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .rDate(boardEntity.getRDate())
                .build();
    }

    private static final int BLOCK_PAGE_NUM_COUNT = 5;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 4;       // 한 페이지에 존재하는 게시글 수

//    @Transactional
//    public List<BoardDto> getBoardList() {
//        Page<Board> page = boardRepository.findAll(PageRequest.of(
//                pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "rDate")));
//
//        List<Board> boardEntities = page.getContent();
//        List<BoardDto> boardDtoList = new ArrayList<>();
//
//        for (Board board : boardEntities) {
//            boardDtoList.add(this.convertEntityToDto(board));
//        }
//
//        return boardDtoList;
//    }

    @Transactional
    public Long getBoardCount() {
        return boardRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 (올림으로 계산)
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

    /**
     * 검색한 목록에 대한 페이징은?
     *  - 유알엘 쿼리 스트링으로 키워드랑 페이지값을 넘겨줘야 한대
     */

//    @Transactional
//    public List<BoardDto> searchPosts(String keyword) {
//        List<Board> board = boardRepository.findByTitleContaining(keyword);
//        List<BoardDto> boardDtoList = new ArrayList<>();
//
//        if (board.isEmpty()) return boardDtoList;
//
//        for (Board boardEntity : board) {
//            boardDtoList.add(this.convertEntityToDto(boardEntity));
//        }
//
//        return boardDtoList;
//    }


    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .rDate(board.getRDate())
                .build();

        return boardDTO;
    }

//    @Transactional
//    public Long savePost(BoardDto boardDto) {
//        return boardRepository.save(Board.of(boardDto)).getId();
//    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
