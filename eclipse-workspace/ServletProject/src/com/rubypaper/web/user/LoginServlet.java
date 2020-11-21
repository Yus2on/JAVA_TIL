package com.rubypaper.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력정보 추출 
		String id = request.getParameter("id");
		String password = request.getParameter("password"); 
		
		
		// 2. DB 연동 처리 (by DAO, VO)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		
		// 3. 화면 네비게이션 
		if(user != null) {
			// 로그인 성공 시 세션에 상태정보 저장 
			// 브라우저를 종료하지 않았다면 재사용 됨 
			// 세선에 저장된 상태 정보는 브라우저가 종료되기 전까지 유효함 
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(10); // 초(second) 단위로 지정 
			session.setAttribute("user", user);
//			session.setAttribute("userId", user.getId());
//			session.setAttribute("userName", user.getName());
//			session.setAttribute("userRole", user.getRole());
			// userId 라는 키값으로 유저 정보가 저장 됨 
			// HashMap(키/밸류) 쌍으로 정보 저장 하는데 세션도 비슷함 
			
			// 로그인 성공시 글 목록 화면으로 바로 이동 
			response.sendRedirect("getBoardList.do");
			
			// 로그인 성공한 경우, 브라우저에 성공 메시지 전송
			response.setContentType("text/html; charset=EUC-KR");
			// 응답으로 출력할 메시지에 한글이 포함되어 있을 때 
			
			PrintWriter out = response.getWriter();
			System.out.println(user.getName() + " 님 로그인 성공(Server Console)");
			out.println("<h1>" + user.getName() + " 님 로그인 성공(Browser)</h1>");
			out.println("<h1><a href='getBoardList.do'> 글 목록 화면으로 이동 </h1>");
			out.println("<h1><a href='insertBoard.html'> 글 등록 화면으로 이동 </h1>");
		} else {
			// 로그인 실패 시, 다시 로그인 화면으로 이동 
			response.sendRedirect("login.html");
		}
		
	}

}
