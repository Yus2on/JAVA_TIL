package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		// 1. 사용자 요청 path 정보를 추출 한다 .
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. 추출된 path 에 따라 요청을 분기처리한다. 
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO(); 
		vo.setId(id);             
		vo.setPassword(password);
		
		UserDAOJDBC userDAO = new UserDAOJDBC();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			// 로그인 성공 했을 때 세션에 상태정보 저장 
			// HttpSession seesion = request.getSession(); -> session은 req랑 res처럼 그냥 씀
			// 내장 객체임 (= JSP 한정 )
			// 서블릿에선 무조건 세션을 얻어야 했지만 jsp는  아님 
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// forward: 이나 redirect: 을 뷰이름 앞에 붙이면 ViewResolver 를 무시한다 (=파싱한다 )
			mav.setViewName("forward:getBoardList.do");
		} else {
			mav.setViewName("redirect:login");
		}
		return mav;
	}

}
