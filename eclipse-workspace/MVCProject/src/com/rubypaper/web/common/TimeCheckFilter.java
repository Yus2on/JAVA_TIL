package com.rubypaper.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class TimeCheckFilter implements Filter {

    public TimeCheckFilter() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 클라이언트가 요청한 서블릿 정보 추출 
		HttpServletRequest req = (HttpServletRequest) request; // 명시적 형변환 해야 URI 정보 추출 
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long startTime = System.currentTimeMillis();
		chain.doFilter(request,response); // 클라이언트가 호출한, 실제 서블릿을 실행시키는 코드임 
		
		long endTime = System.currentTimeMillis();
		System.out.println(path + " 요청 처리에 소요된 시간 : " + (endTime - startTime ) + "(ms)초" );
		// 모든 *.do 요청에 대해필터가 작동하도록 되어있어서 다른 페이지를 먼저 요청해도 
		// 타임 필터가 먼저 실행이 되고 클라이언트가 호출한 서블릿의 메서드 실행하고 끝나면 제어권은 다시 필터로 돌아옴
		// 사후처리까지 처리되서 응답이 필터에서 브라우저로 돌아감 
		
		// 필터는 서블릿이 실행되기 전에 무조건 동작하고 서블릿이 실행한 후에도 동작함 
		// 어떤 서블릿이 실행될때 유난히 시간이 오래걸린다면 걔의 자바코드를  빠르게 최적화(튜닝)해야하기 때문에
		// 그걸 찾으려고 사용함 -> 모니터링 시 유용함 
	}
	
	public void destroy() {
	}

	

}
