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
		<form action="insertBoard.do" method="post">
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