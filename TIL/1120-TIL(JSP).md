# JSP(Java Server Page)

## JSP 란?

* HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 서버 사이드 스크립트 언어이다.
* 웹 어플리케이션 서버에서 동작 

<br>

<br>

## JSP의 등장 

### 서블릿(Servlet)의 단점

- 서블릿 위저드를 이용해 서블릿 하나 생성 하거나 설정 시 web.xml 에 추가 필요
- 응답 화면 별도 구성. 한글 포함 여부로 ` response.setContentType("text/html; charset-EUC-KR")` 처럼 인코딩 설정 필요
- `getWriter()` 를 이용하여 HTML 화면 구성 필요
  - HTML 화면 (= 디자인 코드) 를 구현할 때도 `out.println("<html>")`  ->  직접 출력 스트림 
  - 자바 문법에 맞게 작성해야 했기 때문에 가독성이 떨어지고 대규모 프로젝트에서 사용하기 어려움 
- 코드 수정 -> 반영(확인) 시 웹 페이지 새로고침으로 확인 불가능. 서버가 다시 로딩될 때까지 기다려야 함 

> 이런 단점을 개선시켜 나온 것이 JSP

<br>

<br>

## JSP의 특징

- 서블릿을 기반으로 동작하며 서블릿에 비해 작성 코드 간결 
  - 실행 시 서블릿으로 변환 -> 실행 
  - 오류가 생기면 서블릿 파일에 대한 로그 생성 -> 서블릿 파일 확인으로 로그 확인 가능 
- JSP로 작성한 코드 실행 -> 서블릿의 service() 에 들어감 
- web.xml에 따로 설정하지 않아도 됨
- 디자인 중심. 사용할 만큼의 자바 코드만 사용 가능 
- _jspService() 메서드에는 작성했던 코드가 들어가는데 매개변수로 `request` 와   `reponse` 가 있기 때문에 선언하지 않고 사용 가능 

<br>

### JSP 문법

- 세미콜론 (;) 을 사용하지 않는다
- css 요소를 넣고싶다면  `<font color="red"\><%= code %></font\> ` 사용 
- HTML 용 주석은 jsp 가 서블릿으로 변환될 때 포함이 되지만 `<%-- --%>` 서블릿으로 변환되지 않는다. 
  - ​	 `<%-- --%>`  을 주석으로 쓰는 경우는 거의 없음 

####	`<% code %>` Scriptlet

- 스크립틀릿은 일반적인(정상적인) 자바 코드를 쓸 때 사용

#### `<%= code %>` Expression

- 변수, 메소드 (리턴 타입이 void 가 아닌 리턴하는 메서드만 가능) 호출 가능

```java
<%@page import="java.util.List"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
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
    %>


<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<h3><a href='logout_proc.jsp'>Log-out</a></h3>
<hr>
<form action='updateBoard_proc.jsp' method='post'>
<input type='hidden' name='seq' value='<%= board.getSeq() %>'/>
<table border='1' cellpadding='0' cellspacing='0'>
<tr>
<td bgcolor='orange' width='70'>제목</td>
<td align='left'><input name='title' type='text' value='<%= board.getTitle() %>'/></td>
</tr>
<tr>
<td bgcolor='orange'>작성자</td>
<td align='left'><%= board.getWriter() %></td>
</tr>
<tr>
<td bgcolor='orange'>내용</td>
<td align='left'><textarea name='content' cols='40' rows='10'><%= board.getContent() %></textarea></td>
</tr>
<tr>
<td bgcolor='orange'>등록일</td>
<td align='left'><%= board.getRegDate() %></td>
</tr>
<tr>
<td bgcolor='orange'>조회수</td>
<td align='left'><%= board.getCnt() %></td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='글 수정'/>
</td>
</tr>
</table>
</form>
<hr>
<a href='insertBoard.html'>글등록</a>
<% if(user.getRole().equals("ADMIN")) { %>
	<a href='deleteBoard_proc.jsp?seq=<%= board.getSeq() %>'>글삭제</a>
<% } %>
<a href='getBoardList.jsp'>글목록</a>
</center>
</body>
</html>

```

<br><br>

## JSP 내장 객체

### JSP 내장 객체란?

- JSP 내에서 선언하지 않고 사용할 수 있는 객체
- 구조적으로 JSP가 서블릿 형태로 자동 변환된 코드 내에 포함되어 있는 멤버변수, 메서드, 매개변수 등의 각종 참조 변수(객체)

<br>

### 내장객체의 특징

- 서블릿으로 변경된 JSP코드는 모두 .jspService()매서드에 위치
- 메서드 매개변수인 `request`, `reponse`를 비롯한 pageContent, session, applcation, page, config, out 등 메서드 내에서 참조할 수 있는 참조변수들이 내장객체가 된다 

<br>

### Request

- 사용자 요청과 관련된 기능을 하는 내장 객체 (= 사용자 입력 정보를 읽어올 때 )
- javax.servlet.http.HttpServletRequest 클래스에 대한 참조 변수
- 주료 클라이언트에서 서버로 전달되는 정보 처리
- HTML 폼을 통해 입력된 값을 JSP 에서 가져올 때 사용

| 메서드                   | 설명                                                         |
| ------------------------ | ------------------------------------------------------------ |
| getParameterNames()      | 현재 요청에 포함된 매개변수의 이름을 열거(Enumeration) 형태로 넘겨준다. |
| getParameter(name)       | 문자열 name과 이름이 같은 매개변수의 값을 가져온다.          |
| getParameterValues(name) | 문자열 name과 이름이 같은 매개변수의 값을 배열형태로 가져온다. |
| getCookies()             | checkbox, multiple list등에 주로 사용한다.<br>모든 쿠키 값을 javax.servlet.http.Cookie의 형태로 가져온다. |
| getMethod()              | 현재 요청이 GET아나 POST형태로 가져온다.                     |
| getSession()             | 현재 세션 객체를 가져온다.                                   |
| etRemoteAddr()           | 클라이언트의 IP주소를 알려준다                               |
| setCharacterEncoding()   | 현재 JSP로 전달되는 내용을 지정한 케릭터셋으로 변환. HTML폼에서 한글 입력을 정상적으로 처리 해주려면 반드시 필요하다. |

<br>

### Reponse

- 사용자 응답과 관련된 기능 제공
- 사용차 요청(request)를 처리하고 응답을 다른 페이지로 전달하는 등의 기능 제공 
- javax.servlet.http.HttpServletResponse 객체에 대한 참조변수
- **setContentType, sendRedirec**

| 메서드                   | 설명                                                         |
| ------------------------ | ------------------------------------------------------------ |
| setContentType(type)     | 문자열 형태의 type에 지정된 MIME으로 content Type을 설정     |
| setHeader(name,value)    | 문자열 name의 이름으로 문자열 value의 값을 헤더로 세팅       |
| setDateHeader(name,date) | 문자열 name의 이름으로 date에 설정된 밀리세컨드 시간 값을 헤더에 설정 |
| sendError(status,msg)    | 오류코드를 세팅하고 메시지를 보냄                            |
| sendRedirect(ur)         | 클라이언트 요청을 다른페이지로 보냄                          |

<br>

### out

- 출력 스트림 -> 사용자 웹 브라우저로 출력하기 위한 내장 객체 
- 스크립트에서 브라우저로 텍스트를 출력하는 데 사용
- javax.servlet.jspWriter객체의 참조변스
  - 버퍼관련 메서드와 출력 관련 메서드로 구성
  - out를 이용해서 출력한 내용을 서버의 콘솔이 아닌 사용자에게 전달

| 메서드           | 설명                                               |
| ---------------- | -------------------------------------------------- |
| getBufferSize()  | output buffer의크기를 바이트로 알려준다            |
| getRemaining()   | 남아있는 버퍼의 크기중 사용가능한 비율을 알려준다. |
| clearBuffer()    | 버퍼에 있는 콘텐트를 모두 삭제                     |
| flush()          | 버퍼를 비우고 output stream도 비운다.              |
| close()          | output stream을 닫고 버퍼를 비운다                 |
| println(content) | content의 내용을 newline과 함께 출력한다.          |
| print(content)   | content의 내용을 출력한다.                         |

<br>

### session

- HTTP프로토콜은 비연결형 프로토콜 -> 출력된 다음 클라이언트와 연결 끊어짐 ->  한번 로그인한 사용자가 로그아웃할 때 까지 페이지를 이동해도 보관해야 할 정보가 있다면 이에 대한 처리가 복잡
- 이러한 HTTP 프로토콜 문제점 해결을 위해 나온 것이 `쿠키(cookie)` 와 `세션(session) `
  - session은 javax.servlet.http.Http Session 인터페이스 참조 변수
  - session은 접속하는 사용자 별로 따로 생성되며 일정시간 유지되고 소멸
  - 이러한 세션의 특징을 이용해 setAttribute() 메서드 이용 -> 임의의 값을 저장해놓고  활용할 수 있다.
  - 세션이 주로 사용되는 경우 :
    - 사용자 로그인 후 세션을 설정하고, 일정시간이 지난 경우 다시 사용자 인증 요구할 때 
    - 쇼핑몰에서 장바구니 기능 구현
    - 사용자의 페이지 이동 동선 등 웹 페이지 트래킹 분석 기능 등 구현 

| 메서드                    | 설명                                                         |
| ------------------------- | ------------------------------------------------------------ |
| getId()                   | 각 접속에 대한 세션 고유의 ID를 문자열 형태로 반환           |
| getCreatingTime()         | 세션 생성기간을 January 1,1970 GMT부터 long형 밀리세컨드 값으로 반환 |
| getLastAccessedTime()     | 현재 세션으로 마지막 작업한 시간을 long형 밀리세컨드 값으로 반환 |
| setMaxInactiveInterval(t) | 세션의 유지시간을 초로 반환 -> 세션의 유효시간 파악 가능     |
| invalidate()              | 현재 세션 종료. 세션과 관련된 값이 모두 지워짐               |
| getAttribute(attr)        | 문자열 attr로 설정된 세션값을 java.lang.Object 형태로 반환   |
| setAttribute(name,attr)   | 문자열 name으로 java.lang.Object attr을 설정한다.            |

<br>

### 그 밖의 내장 객체

- **Config**

  - 서블릿이 최초로 메모리에 적재될 때 컨터이너는 서블릿 초기화와 관련된 정보를 읽고 javax.servlet.ServletConfig 객체에 저장
  - config는 바로 ServletConfig클래스에 대한 참조 변수로 web.xml에 설정된 초기화 파라미터를 참조하기 위한 용도로 사용할 수 있다.

- **Application**

  - 웹 애플리케이션(컨텍스트) 전체를 관리하는 객체로 application 객체를 통해 각 서블릿이나 JSP에서 공유하려고 하는 각종 정보를 설정하고 참조 가능
  - avax.servletContext객체에 대한 참조 변수. config 객체를 통해 생성
  - ServletContext 객체는 컨터이너와 관련된 정보를 제공 -> application참조 변수를 통해서 서블릿이 실행되는 환경이나 서버 자원과 관련한 정보를 얻거나 로그파일을 기록하는 작업 등 수행
  - application 내장객체는 일반적으로 톰캣의 시작과 종료 라이프사이클을 가진다.
  - 유형별로 많은 메서드를 제공하므로 주로 관리 기능의 웹 애플리케이션 개발에 유용

- **Attribute**

  | 메서드                                  | 설명                                                         |
  | --------------------------------------- | ------------------------------------------------------------ |
  | getAttribute(String name)               | 문자열 name에 해당하는 속성 값이 있다면 Object형태로 가져옴 -> 변환 값에 대한 적절한 형 변환 필요 |
  | getAttributeNames()                     | 현재 application객체에 저장된 속성들의 이름을 열거 형태로 가져온다. |
  | setAttribute(String name, Object Value) | 문자열 name이름으로 Object형 데이터를 저장한다. Object형이므로 자바 클래스 형태로도 저장 할 수 있다. |
  | removeAttribute(String name)            | 문자열 name에 해당하는 속성을 삭제                           |

  