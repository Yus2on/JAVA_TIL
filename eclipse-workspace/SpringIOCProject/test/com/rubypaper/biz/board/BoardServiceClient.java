package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String [] args) {
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
	
		BoardService boardService = (BoardService) container.getBean("BoardService");
		if(boardService != null) {
			System.out.println(boardService + " : Lookup 성공");
		}
		
		BoardVO vo = new BoardVO();
		vo.setTitle("Spring 제목");
		vo.setWriter("테스터");
		vo.setContent("Spring 내용 1234 ");
		boardService.insertBoard(vo);
		
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println(" [ BOARD LIST ] ");
		
		for(BoardVO board : boardList) {
			System.out.println("-->" + board.toString());
		} // end for
		
		container.close();
		
		

	
	}
}
