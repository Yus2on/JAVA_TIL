package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;

@Controller
public class LoginController {
	// 로그인 화면 처리 
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login (UserVO vo){
		vo.setId("admin");
		vo.setPassword("admin");
		return "login";
	}
	

	// 로그인 
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login (UserVO vo, UserDAOJDBC userDAO, HttpSession session){
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			// 로그인 성공 했을 때 세션에 상태정보 저장 
			// HttpSession seesion = request.getSession(); -> session은 req랑 res처럼 그냥 씀
			// 내장 객체임 (= JSP 한정 )
			// 서블릿에선 무조건 세션을 얻어야 했지만 jsp는  아님 
			session.setAttribute("user", user);
			return "forward:getBoardList.do";
		} else {
			return "login";
		}
	}

	// 로그아웃 
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:lndex.jsp";
	}

}
