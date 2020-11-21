package com.rubypaper.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserVO;

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBoardListServlet() {
		System.out.println("==> GetBoardListServlet 생성 ");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0. 세션 체크
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		
		
//		HttpSession session = request.getSession();
//		if (session.getAttribute("userId") == null) { // userId 이걸로 된 정보가 없으면 로그인 화면으로 이동
//			response.sendRedirect("login.html");
//		} else {

		// 글 목록 화면을 요청한 브러우저와 매핑된 세션 객체를 얻는다. (request = Browser)
		// 세션은 서버 메모리에 생성되고 브라우저 하나당 하나씩만 생김. 브라우저가 살아있으면 계속 재사용이 됨
//	HttpSession session = request.getSession(); // 세션 객체를 얻음 
//	if (session.isNew()) { // 세션이 처음 만들어진 상태라면 
//		System.out.println("==> GetBoardListServlet 처음 생성한 세션  ");
//	} else {
//		System.out.println("--> 이전에 생성된 새션 재사용 ");
//	}

		// 1. 사용자 입력정보 추출 (검색 기능 은 과제 )
		// request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		String condition = request.getParameter("searchCondition");
		String keyword = request.getParameter("searchKeyword");

		// Null Check
		if (condition == null || condition.isEmpty()) {
			condition = "none";
		}

		if (keyword == null || keyword.isEmpty()) {
			keyword = "";
		}

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(condition);
		vo.setSearchKeyword(keyword);

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 3. 응답 화면 구성
		// 디자인을 바꾸기 힘들어서 서블릿을 안 쓰게 됨
		// 아래와 같이 out.~~~ 어쩌구 백만개 사용
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println(
				"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<title>글 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시글 목록</h1>");
		out.println("<h3><font color='red'>" + user.getName() + "</font>님 로그인 환영합니다......");
		out.println("<a href='logout.do'>Log-out</a></h3>");

		out.println("<!-- 검색 시작 -->");
		out.println("<form action='getBoardList.do' method='post'>");
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
			out.println("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle()
					+ "</a></td>");
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
