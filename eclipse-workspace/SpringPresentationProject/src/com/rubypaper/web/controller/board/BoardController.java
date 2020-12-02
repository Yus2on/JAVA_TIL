package com.rubypaper.web.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

// @SessionAttributes(복수형, 배열형태로 여러개 가능 ) 를 이용하면 특정 이름으로 Model 에 저장한 데이터를 세션에도 등록되도록 한다
// 	- getBoard() 메소드애서 Model에 "board" 라는 이름으로 BoardVO() 객체를 Model 에 저장하면 
//	  세션에도 "board" 라는 이름으로 BoardVO 객체가 등록되는 것이다 
//@SessionAttributes({"aa","bb","cc"})
@SessionAttributes("board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardService;

	// 글 등록 화면 이동 
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	// 똑같은 밸류값이 들어왔을때 요청방식이  포스트 방식이냐 겟방식이냐 에따라서 다른 메서드를 실행  
	public String insertBoardView (BoardVO vo) {
		// 매개변수로 받은 VO 객체는 자동으로 request 내장 객체 등록된다 
		// 	- 최종적으로 실행되는 화면(JSP)에서 EL을 이용하여 값을 뿌릴 수 있다 
		vo.setTitle("200 자 미만으로 ... ");
		vo.setWriter("테스터");
		vo.setContent("2000 자 미만으로 작성해주세요");
		return "insertBoard";
	}
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard (BoardVO vo) {
		System.out.println("게시 글 등록 기능 처리");
		
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 수정 
	// @ModelAttribute 는 세션에 "board" 라는 이름으로 데이터가 등록되어 있다면 그 객체를 vo 변수에 바인딩 한다는 의미 
	// 없으면 말고 
	@RequestMapping("/updateBoard.do")
	public String updateBoard (@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 BoardVO 객체 정보");
		System.out.println(vo.toString());
		
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 삭제   
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard (BoardVO vo) {
		// 지금당장은 매개변수 seq 하나만 받더라도 BoardVO 전부 받는 것이 나음
		// 유지보수 대비용. 파라미터가 늘어나거나 줄어나면 전부 수정해야하기 때문에  
		System.out.println("게시 글 삭제 기능 처리");
		
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	/*
	// 글 삭제   
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard (@RequestParam(value="seq", defaultValue="1", required=true) int boardSeq, BoardDAOJDBC boardDAO) {
		// 기본형타입도 상관없음 
		// 파라미터랑 매개변수 이름이 똑같으면 컨테이너가 파라미터 값을 매개변수에 할당해ㄷ줌 
		// 어노테이션 사용하면 파라미터 이름과 매개변수 이름이 달라도 값이 들어감 -> 거의 쓸 일 없음  
		// 옵션 defaultValue="1" -> value 가 null 이거나 없다면 1로 처리
		// required=true seq (파라미터) 값이 필수임 생략 불가능  전달되지 않으면 Exception  
		System.out.println("게시 글 삭제 기능 처리");
		
//		boardService.deleteBoard(vo);
		System.out.println(boardSeq + " 번 글 삭제 처리 .... ");
		return "forward:getBoardList.do";
	}
	*/
	
	// 글 상세 조회   
	@RequestMapping("/getBoard.do")
	public String getBoard (BoardVO vo, Model model) {
		System.out.println("상세 화면에서의 BoardVO 객체 정보 ");
		System.out.println(vo.toString());
		// Model 에 저장한 데이터는 자동으로 Request에 등록된다. (세션이 아님) 
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	// 글 목록 검색   
	@RequestMapping("/getBoardList.do")
	public String getBoardList (BoardVO vo, Model model) {
		// Null chk 
		System.out.println("목록 검색 기능 처리");
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// 절대 검색 결과는 세션에 저장해서는 안된다. 검색 결과는 request 에 등록해야 한다. 
		// ModelAndView나  Model 객체에 검색 결과를 등록하면 자동으로 세션이 아닌 request 에 등록해준다
		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("search", vo);
		return "getBoardList";
	}

}
