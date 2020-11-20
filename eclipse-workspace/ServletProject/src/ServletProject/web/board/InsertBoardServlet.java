package ServletProject.web.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding; // 생성자 ㅁ ㅔ서드로 초기화할수 없음 서블릿은 디폴트 메서드만허용 

	// 디폴트 메서드 호출 후 init 메서드 딱 한번 호출 -> 서블릿 엔진 호출함 
	// 서블릿 config  객체 생성 -> 로컬 파라미터 정보를 config에 세팅해줌 
	// config 객체가 init 메서드 호출될 떄 전달됨 ( 리퀘스트와 비슷) 

	//  로컬 파라미터는 여러개를 등록 할 수 있음
	// init param1, 2......키 값이 똑같으면 충돌나기때문에 다  다르게 등록해야됨 
	// 파라미터 이름이 boardEncoding 일때 config에서 걔를추출 
	
	// 서버를 껏다 켜는 이유는 web.xml 이 수정 되서 
	// 이짓을 하는 이유는 나중에 인코딩 정책이 바뀌면 xml만 수정하기 위해(= 자바소스 건들지 않기위해)
	// 로컬 파라미터의 문제는 한글인코딩이 필요할때마다 로컬 파라미터가 필요함 ->인코딩 정책이 바뀌면 많은 파일을수정해야 됨 
	// 그래서 welcome-file-list 밑에 Global-parameter  설정 
	
	
	// 서블릿 컨텍스트는 getServletContext 로 서블릿컨텍스트 객체 가져옴
	// 얘는 부모로부터 상속된 것 
	
	
	/*
	public void init(ServletConfig config) throws ServletException {
		// web.xml  파일에 설정된 로컬 파라ㅣ터 정보 추출 
		encoding = config.getInitParameter("boardEncoding");
	}
	*/
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 글로벌 파라미터 정보 추출 
		//ServletContext 객체를 이용하면 글로벌 파라미터
		// 모든 서블릿에서 다쓸 수 있음 
		ServletContext context = getServletContext();
		encoding = context.getInitParameter("boardEncoding");
		
		
		// 1. 사용자 입력 정보 추출 
		response.setCharacterEncoding(encoding);
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
	
	}

}
