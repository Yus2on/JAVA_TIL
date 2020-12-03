<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>글 등록</h1>
	<hr>
	<!-- 
		글 등록 화면을 파일 업로드 가능한 화면으로 수정한다.
		<form> 시작 태그에 method="POST" GET 방식은 파일 업로드를 지원하지 않는다.
		그리고 enctype="multipart/form-data" 속성이 설정되어야 이 form이 업로드 기능을 지원하는 것이다.
	-->
		<form action="insertBoard.do" method="post"  enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td><td align="left">
				<input type="text" name="title" value="${boardVO.title} "/></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td><td align="left">
				<input type="text" name="writer" size="10" value="${boardVO.writer} " /></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td><td align="left">
				<textarea name="content" cols="40" rows="10">${boardVO.content} "</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="글 등록"/></td>
			</tr>
		</table>
		</form>
	<hr>
</center>
</body>
</html>