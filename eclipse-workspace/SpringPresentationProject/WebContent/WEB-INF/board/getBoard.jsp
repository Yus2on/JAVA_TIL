<%-- <%@page import="java.util.List"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- 

	EL (Expression Language) 이란?
		- JSP 파일에서 request나 session( = 내장객체) 에 등록한 데이터를 접근하기 위한 표현식 
		- JSP에서 완벽하게 자바 코드 삭제 
		- 리퀘스트에서 먼저 찾고 적용함 (우선순위가 리퀘스트가 높음 ) 
		- 대소문자 구분함 
		
		
	JSTL (JSP Standard Tag Library) 이란? 
		- JSP 파일에서 if(), for(), switch() 등과 같은 자바 코드를 대체하는 JSP 표준 태그 
		- jstl, standard 라이브러리는 이것과 관계 없음 	
		
 -->


<!--  
	// 이제 안 쓰는 로직 
	//0. 세션에 등록된 정보 꺼내기 
	UserVO user = (UserVO)session.getAttribute("user");
		

	//1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);

	// 3. 응답 화면 구성
-->



<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<h3>
			<a href='logout.do'>Log-out</a>
		</h3>
		<hr>
		<form action='updateBoard.do' method='post'>
			<input type='hidden' name='seq' value='${ board.seq } }' />
			<!--  ${board.seq}   seq는 프라이빗인데 이렇게 쓰면 자동적으로 getSeq() 호출하게 됨 만약엔 seq란게 없으면 패스됨 -->

			<table border='1' cellpadding='0' cellspacing='0'>
				<tr>
					<td bgcolor='orange' width='70'>제목</td>
					<td align='left'><input name='title' type='text'
						value='${ board.title }' /></td>
				</tr>
				<tr>
					<td bgcolor='orange'>작성자</td>
					<td align='left'>${ board.writer }</td>
				</tr>
				<tr>
					<td bgcolor='orange'>내용</td>
					<td align='left'><textarea name='content' cols='40' rows='10'> ${ board.content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor='orange'>등록일</td>
					<td align='left'>${ board.regDate }</td>
				</tr>
				<tr>
					<td bgcolor='orange'>조회수</td>
					<td align='left'>${board.cnt }</td>
				</tr>
				<tr>
					<td colspan='2' align='center'><input type='submit'
						value='글 수정' /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href='insertBoard.do'>글등록</a>
		<c:if test="${user.role == 'ADMIN' }">
			<a href='deleteBoard.do?seq=${board.seq }'>글삭제</a>
		</c:if>
		<a href='getBoardList.do'>글목록</a>
	</center>
</body>
</html>
