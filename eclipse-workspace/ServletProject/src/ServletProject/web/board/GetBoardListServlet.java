package ServletProject.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1. 사용자 입력정보 추출 (검색 기능 은 과제 )
	String condition = request.getParameter("searchCondition");
	String keyword = request.getParameter("searchKeyword");
	
	if (condition == null || condition.isEmpty()) {
		condition = "none";
	}
	
	if (keyword == null || keyword.isEmpty()) {
		keyword = "";
	}
		
	// 2. DB 연동 처리 
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);
	
	// 3. 응답 화면 구성 
	// 디자인을 바꾸기 힘들어서 서블릿을 안 쓰게 됨 
	// 아래와 같이 out.~~~ 어쩌구 백만개 사용 
	response.setContentType("text/html; charset=EUC-KR");
	PrintWriter out = response.getWriter();
	
	out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
	out.println("<title>글 목록</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<center>");
	out.println("<h1>게시글 목록</h1>");
	out.println("<h3>테스트님 로그인 환영합니다......");
	out.println("<a href='logout.do'>Log-out</a></h3>");

	out.println("<!-- 검색 시작 -->");
	out.println("<form action='getBoardList.do' method='get'>");
	out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
	out.println("<tr>");
	out.println("<td align='right'>");
	out.println("<select name='searchCondition'>");
	out.println("<option value='TITLE'>제목");
	out.println("<option value='CONTENT'>내용");
	out.println("</select>");
	out.println("<input name='searchKeyword' type='text'/>");
	out.println("<input type='submit' value='검색'/>");
	out.println("</td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("<!-- 검색 종료 -->");

	out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
	out.println("<tr>");
	out.println("<th bgcolor='orange' width='100'>번호</th>");
	out.println("<th bgcolor='orange' width='200'>제목</th>");
	out.println("<th bgcolor='orange' width='150'>작성자</th>");
	out.println("<th bgcolor='orange' width='150'>등록일</th>");
	out.println("<th bgcolor='orange' width='100'>조회수</th>");
	out.println("</tr>");

	for (BoardVO board : boardList) {
		out.println("<tr>");
		out.println("<td>" + board.getSeq() + "</td>");
		out.println("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
		out.println("<td>" + board.getWriter() + "</td>");
		out.println("<td>" + board.getRegDate() + "</td>");
		out.println("<td>" + board.getCnt() + "</td>");
		out.println("</tr>");
	}

	out.println("</table>");
	out.println("<br>");
	out.println("<a href='insertBoard.html'>새글 등록</a>");
	out.println("</center>");
	out.println("</body>");
	out.println("</html>");
	
	out.close();
	}

}
