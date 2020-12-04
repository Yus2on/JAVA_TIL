package com.rubypaper.biz.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardServiceClient {
	public static void main(String[] args) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", "MyBATIS 제목 ");
		paramMap.put("writer", "테스터");
		paramMap.put("content", "MyBATIS 내용");
		
		BoardDAOMyBATIS boardDAO = new BoardDAOMyBATIS();
		boardDAO.insertBoard(paramMap);
		
		BoardVO vo = new BoardVO();
		List<Map<String, Object>> boardList = boardDAO.getBoardListMap(vo);
		for (Map<String, Object> board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
