package com.rubypaper.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;

public class DispatcherServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServelt() {
    	System.out.println("===> DispatcherServelt 생성 ");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 path 정보를 추출 한다 .
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		
		// 2. 추출된 path 에 따라 요청을 분기처리한다. 
		if (path.equals("/login.do")) {
			System.out.println("로그인 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO(); 
			vo.setId(id);             
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. 화면 네비게이션
			if(user != null) {
				// 로그인 성공 했을 때 세션에 상태정보 저장 
				// HttpSession seesion = request.getSession(); -> session은 req랑 res처럼 그냥 씀
				// 내장 객체임 (= JSP 한정 )
				// 서블릿에선 무조건 세션을 얻어야 했지만 jsp는  아님 
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.html");
			}
			
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 기능 처리");
			
			// 로그아웃을 요청한 브라우저에 해당하는 세션 객체를 강제 종료한다. 
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.html");
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("게시 글 등록 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("게시 글 수정 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("게시 글 삭제 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("게시 글 상세 조회 기능 처리");			

			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			// 3. 검색 결과를 세션에 등록하고 JSP화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("게시 글 목록 검색 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// Null Check
			if(searchCondition == null) searchCondition = "TITLE";
			if(searchKeyword == null) searchKeyword = "";
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSearchCondition(searchCondition);
			vo.setSearchKeyword(searchKeyword);
			
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 3. 검색 결과를 화면(JSP)에서 사용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			// 글 목록 화면(getBoardList.jsp)으로 이동한다.
			response.sendRedirect("getBoardList.jsp");
			
			
		} else {
			System.out.println("URL을 다시 확인해주시기 바랍니다.");
		}
	}
	

}
