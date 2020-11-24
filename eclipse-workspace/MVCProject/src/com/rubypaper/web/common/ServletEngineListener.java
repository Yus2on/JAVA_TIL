package com.rubypaper.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// Listener implements 하고 web.xml에 올라감 
// 필터가 아무리 많이 있어도 Listener가 제일 먼저 올라감 
public class ServletEngineListener implements ServletContextListener {

	public ServletEngineListener() {
		System.out.println("==> ServletEngineListener 생성 ");
	}

	// 엔진 초기화 메서드
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("--> 서블릿 엔진이 생성된 직후에 무조건 실행 ");
		// 서블릿 프로그램이 동작하기 전에 무조건 딱 한 번 실행해야 하는 로직이 있다면
		// 여기에 구현하면 됨 
		// 스프링 MVC 공부할 때 요긴하게 쓰임 
	}

	// 엔진 종료 메서드
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--> 서블릿 엔진이 삭제되기 직전에 무조건 실행 ");
	}

}
