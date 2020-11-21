package com.rubypaper.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionChkFlter implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 0. 세션 체크
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		if(!path.equals("/login.do")) {
			HttpSession session = req.getSession();		
			if(session.getAttribute("user") == null) {
				res.sendRedirect("login.html");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}
	
    public SessionChkFlter() {
    }
	

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
