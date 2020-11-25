package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//4. Service 구현 클래스 비즈니스 로직 클래스
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
//	public BoardServiceImpl() {
//		System.out.println("==> BoardServiceImpl() 생성 ");
//	}
	
/*	클래스 위에 컴포넌트, 변수 위에 오토와이어드쓰면 멤모리에 올라가고 객체에 할당되므로 
 *  필요 없음 
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
*/
	
	@Override
	public void insertBoard(BoardVO vo) {
		// System.out.println("[ 사전처리 ] 비즈니스 로직 수행 전 동작");
		boardDAO.insertBoard(vo);
	}
	
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}
