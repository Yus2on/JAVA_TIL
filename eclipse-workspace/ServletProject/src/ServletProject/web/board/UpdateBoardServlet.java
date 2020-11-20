package ServletProject.web.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 글로벌 파라미터 정보 추출 
		//ServletContext 객체를 이용하면 글로벌 파라미터
		ServletContext context = getServletContext();
		encoding = context.getInitParameter("boardEncoding");
		
		// 1. 사용자 입력 정보 추출 
		request.setCharacterEncoding(encoding);
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리 
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. 화면 네비게이션 
		response.sendRedirect("getBoardList.do");
	}

}
