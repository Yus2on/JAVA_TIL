package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("---> index 페이지 요청입니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public void forMember() {
		System.out.println("---> member 페이지 요청입니다.");
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("---> manager 페이지 요청입니다.");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("---> admin 페이지 요청입니다.");
	}
	
	@GetMapping("/login")
	public void login() {
		System.out.println("---> 로그인 화면으로 이동한다.");
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		System.out.println("---> 로그인 성공 화면으로 이동한다.");
	}

	@GetMapping("/accessDenied")
	public void accessDenied() {
		System.out.println("---> 권한이 없음을 알려주는 화면으로 이동한다.");
	}
}











