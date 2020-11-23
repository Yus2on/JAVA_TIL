<%@page import="com.rubypaper.biz.user.UserDAO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
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
		// 내장 객체임
		// 서블렛에선 무조건 세션을 얻어야 했지만 jsp는  아님 
		session.setAttribute("user", user);
		
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.html");
	}
%>
    
