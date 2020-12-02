<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
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

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>게시글 목록</h1>
		<h3>
			<font color='red'>${user.name }</font>님 로그인 환영합니다...... <a href='logout.do'>Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action='getBoardList.do' method='post'>
		<input type='hidden' name='searchCondition' value='${session.searchCondition } }' />
		<input type='hidden' name='searchKeyword' value='${ board.seq } }' />
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<td align='right'><select name='searchCondition'>
						<option value="TITLE" <c:if test="${search.searchCondition == 'TITLE'}">  selected="selected"></c:if>>제목</option>
						<option value="CONTENT" <c:if test="${search.searchCondition == 'CONTENT'}">  selected="selected"></c:if>>내용</option>
					</select> 
					<input name='searchKeyword' type='text' /> 
					<input type='submit' value='검색' /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'>번호</th>
				<th bgcolor='orange' width='200'>제목</th>
				<th bgcolor='orange' width='150'>작성자</th>
				<th bgcolor='orange' width='150'>등록일</th>
				<th bgcolor='orange' width='100'>조회수</th>
			</tr>
			
			<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td align='left'><a href='getBoard.do?seq=${board.seq }'>${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
			</c:forEach>
			
		</table>
		<br> <a href='insertBoard.do'>새글 등록</a>
	</center>
</body>
</html>


