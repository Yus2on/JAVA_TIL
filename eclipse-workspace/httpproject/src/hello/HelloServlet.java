package hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HelloServlet bean = new HelloServlet(); // 객체생성 -> 클래스가 필요한 이유: 객체생성 하려고 . ..
// bean.doGet(); // 클래스에 메서드 만드는 이유 : 내가 구현한 메서드를 호출해서 로직 대로 동작하게 하려고 


/**
 * 서블릿 클래스 작성 규칙 (외워야하지만 이클립스가 이 규칙에 맞게 클래스 생성해줌 ) 
 * 1. HttpServlet 클래스를 상속해야 한다. 
 * 2. public 클래스로 만들어야 한다. 
 * 3. default 생성자가 있어야 한다. 
 * 4. 요청 방식(method)에 따라 doGet(), doPost()를 재정의(Overriding) 한다.
 * 5. 부모(HttpServlet) 클래스의 메소드를 제정의 하지 않으면 상속된다.  
 *
 */

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public HelloServlet() {
    	System.out.println("==> HelloServelt 객체 생성 ");
    }
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("--> init() 호출 ");
	}
	             
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("--> service() 호출 ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--> doGet()  ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void destroy() {
		System.out.println("--> destroy() 호출 ");
	}

}
