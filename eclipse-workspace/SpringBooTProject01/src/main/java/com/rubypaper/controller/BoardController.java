package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubypaper.domain.BoardVO;

@Controller
// @RestController : BoardController가 가진 모든 메서드는 @ResponseBody 를 추가하지 않아도 명시적으로 추가 됨
public class BoardController {
	public BoardController() {
		System.out.println("==> BoardController created ");
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	// @RequestMapping(value="/hello", method=RequestMethod.GET) == GetMapping("/hello")
	// hello요청이 겟으로 들어왓을대 ㄷ아래 hello+name 을 바디에 담아서 보냄 
	@ResponseBody
	public String hello(String name) {
		return "hello :  " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("임시 제목");
		board.setWriter("익명");
		board.setContent("임시 내용...............");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i = 0; i < 5; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(++i);
			board.setTitle("임시 제목" + i);
			board.setWriter("익명" + i);
			board.setContent("임시 내용..............." + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}
