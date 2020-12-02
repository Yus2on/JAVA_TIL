# 서블릿 (Servlet)

## 서블릿이란?

- 클라이언트 요청을 처리하고 그 결과를 다시 클라이언트에게 전송하는 자바 프로그램 
- 자바를 사용했기 때문에 당연히 `JDK` 가 필요 
  - 자바 API & JVM 
- 서블릿을 이해하면 자바의 서버 사이드 쪽 동작원리를 이해하는데 많은 도움이 된다

<br>

<br>

## 서블릿의 특징

- 자바로 작성되어 있기 때문에 플랫폼과 무관하게 동일한 실행결과를 가진다 
  - 플랫폼에 독립적, 이식성이 좋음(= 소프트웨어 품질에서 중요한 부분)
- 자바로 작성되어 있기 때문에 외부 프레임워크 등을 클래스 라이브러리 형태로 사용 가능
- ServletEngine에 의해서만 동작한다.
- **Multi-Thread** 로 동작하기 때문에 웹 환경에서 효율적
  - 서블릿을 멀티 스레드로 동작시키는 것은 서블릿 엔진의 일
  - 서블릿 엔진이  `web.xml` 로딩 -> (스레드 객체들 저장되어 있는)`thread pool` 생성 
- 웹 서버와 무관하게 실행 (= 서버 독립성)

<br>

### 서블릿의 다섯가지 규칙

1. HttpServlet 클래스를 상속해야 한다
2. public 클래스로 생성해야 한다 : 서블릿 엔진에서 접근할 수 있도록. 
3. default 생성자가 있어야 한다 : 만들지 않아도 자동 생성 
4. 요청방식(method) 에 따라 `doGet()` , `doPost()` 를 재정의(Overriding) 한다
5. 부모 (HttpServlet) 클래스의 메서드를 재정의 하지 않으면 상속된다 

<br><Br>

## 서블릿 수행 흐름

![](https://user-images.githubusercontent.com/46306263/100612167-df81e200-3355-11eb-8474-7b539c3ccac0.png)

- 클라이언트에서 서블릿 요청(request) -> 서블릿 엔진은 요청된 서블릿이 메모리에 존재하는지 여부를 판단
- 요청한 서블릿이 메모리에 없다면, web.xml에 매핑된 요청객체를 객체를 찾아서 생성하고 메모리에 로딩
- 생성자 호출. 무조건 디폴트 생성자를 찾아서 메모리에 띄운다 ( = 매개변수가 있는 생성자는 인식하지 못함)
- Init() 호출. 디폴트 생성자가 호출이 되서 서블릿 객체가 메모리에 뜨기 때문에 멤버번수를 **단 한번** 초기화할 때 사용 
- 스레드 풀에서 스레드가 랜덤으로 튀어 나와서 할당 -> 이 스레드가 서블릿 객체의 service() 호출 (스레드는 run()를 호출하게 되어있는데 내부적으로 이 run()은 service()만 호출하게 되어있다.)
  - 메모리에 올라간 서블릿 객체를 스레드 풀에 있는 스레드들이 공유
- service() 메소드를 오버라이딩 하지 않으면 부모의 것이 호출이 되는데 이건 브라우저가 서버에 요청한 방식에 따라서 doGet(), doPost() 메소드를 호출하여서 메소드 동작이 이루어진다.
  - 브라우저의 요청 방식에 대해서 확신이 있다면 해당 메소드만 오버라이딩하면 되는데, 요청 방식을 모르는 경우 service()를 이용하여 모든 요청을 다 처리하면 된다.
- 결과를 응답으로 클라이언트에게 보내준다.
- 처음 서블릿 요청이 들어오게 되면 위의 과정을 처음부터 수행하지만, 한 번 메모리가 할당이 되면 메모리에 존재하기 때문에 그 이후 부터는 5번부터 과정부터 실행 -> 새로운 스레드가 할당되서 실행이 이루어진다. (= 앞의 과정을 생략하므로 수행 속도 빠름)
- 서블릿으로 개발한 시스템은 클라이언트 오픈 전에 한번 다 실행 할 필요가 있음 -> 처음 실행하면 메모리에 올리고 스레드 할당하기때문에 두번째보다 시간이 소요, 이용하는 클라이언트가 모두 비슷한 속도를 제공 받음 
- doPost(), doGet() 메서드 오버라이딩 -> HttpReqest, HttpResponse 객체를 매개변수로 받음 -> 이 매개변수의 객체들도 서블릿 엔진이 생성해서 넣어줌 
  - 먼저 Request, Response 객체 생성 -> doPost(), doGet() 호출
- 서버를 재구동할 때까지 서블릿 객체가 메모리에 존재하지만 서버를 끊으면 서블릿 엔진이 죽어서 서블릿 객체를 메모리에서 회수. 서블릿 객체가 종료되기 직전에 destroy() 메소드가 호출되면서 자원들을 회수하고 종료된다.

<br>

### 톰캣, Apache Tomcat

- Apache : WEB 서버
- Apache Tomcat : WAS (Web Application Server)
  - JAVA EE 기반의 WEB/WAS의 기능을 가진 자바 어플리케이션
  - WAS는 자바로 만들어진 JSP와 Servlet을 구동하기 위한 **[서블릿 컨테이너](#서블릿-컨테이너-(servlet-container))** 역할
  - 톰캣 서버를 구동하면 톰캣 객체 생성 -> 그 안에 포함된 서블릿 엔진 생성
  - 서블릿 엔진은 web.xml 로딩 +  thread pool 생성 + 전체 라이프 사이클 관리
  - 서블릿 엔진은 객체를 생성해주는 코드와 메서드 호출 코드 실행 (= 내부동작 보이지 않게 진행)

<br>

#### 톰캣 구동 흐름 

- 서버 구동 버튼을 누르면 내부적으로 `new tomcat()` 객체 생성
- 톰캣 객체 생성 -> Servlet Engin 생성 
  - 이 서블릿 엔진 객체가 생성될때 web.xml 파일 전달(= 로딩 ) (web.xml 에 오류가 있으면 서버 구동시 오류 출력)
- 톰캣 안에 있는 Servlet Engin 이 메서드 호출 (HelloServlet(), doGet()) 
  - **개발자는 클래스만 생성하고, 객체 생성과 메서드 호출은 서블릿 엔진이 진행**
- server 창에 로그 생성 -> `StartServiceCatalina` : 톰캣 서버 구동 완료
- 서블릿은 톰캣 없이 절대 실행할 수 없음 

<br>

### 서블릿 컨테이너 (Servlet Container)

- 서블릿의 생명주기를 관리하고 요청에 따른 스레드 생성
- 클라이언트의 Request 를 받아주고 Response 를 보낼 수 있게 웹 서버와 소켓을 만들어서 통신
- 웹 환경에서 서블릿이 구동될 수 있도록 해주는 프로그램

<br><br>

## Servlet 단점

```java
PrintWriter writer = response.getWriter();

writer.println("<html>");
writer.println("<head>");
writer.println("</head>");
writer.println("<body>");
writer.println("<h1>helloWorld~</h1>");
writer.println("name : " + request.getParameter("name") + "<br/>");
writer.println("id : " + request.getParameter("id") + "<br/>");
writer.println("pw : " + request.getParameter("pw" + "<br/>"));
writer.println("major : " + request.getParameter("major") + "<br/>");
writer.println("protocol : " + request.getParameter("protocol") + "<br/>");
writer.println("</body>");
writer.println("</html>");
writer.close();
```

- 서블릿은 서블릿 클래스를 상속받기 때문에 `.java`  클래스 파일과 동일 (= 자바 문법에 맞게 작성)
- 그러다보니 클라이언트가 봐야하는 html 코드 출력 작업이 가독성 떨어지고 번거로워짐 
- IO 입출력과 같이 스트림 객체 생성 -> html 코드를 전부 print 필요 

<br>

<br>

## Servlet 주요 객체

### HttpServletRequest

- 클라이언트가 전달한 정보를 추출하기 위해 사용

- Request 객체는 브라우저가 서버쪽으로 보낸 요청 프로토콜이 담겨서 메소드의 파라미터로 전달된다.

  - 엄청나게 많은 정보들이 담겨져서 전송이 된다.

- 클라이언트의 요청이 와서 서블릿 객체가 생성이 될 때 생성되서 전달된다.

- 클라이언트에게 다시 응답이 되기 전까지 계속 상태 유지가 된다.(하나의 요청을 처리하는 스레드에서 용도를 다 할 때까지 존재)

- Request의 주요 사용하는 메소드

  - `getReuestURL()` : URL 호출
  - `getMethod()` : 요청방식 확인 
  - `setCharacterEncoding()` :  입력 정보가 한글로 되어있을 때 변환하기 위해 사용 
  - `getParameter()` :  ? 뒤 파라미터 추출 
  - `getSession()` : 세션 정보 가져옴 
  - `getQueryString()` : 쿼리스트링 출력 

  <br>

### HttpServletResponse

- 프로그램의 처리 결과를 클라이언트로 보내기 위해 사용 

- Response 객체는 클라이언트로 보낼 정보들이 담겨지고, 응답 프로토콜과 관련되서 정보들이 응답 프로토콜에 의해 클라이언트로 전송 된다, 응답을 보내고 사라 진다.

- Response의 주요 사용하는 메소드

  - `setContentType()` : html의 표준 MIME 타입인 **text/html** 의 변경이나 캐릭터의 인코딩을 재 지정할 때 사용

  - `getWriter()` : 클라이언트에 응답하기 위해 데이터타입 **PrintWriter** 으로 생성된 객체를 메서드가 반환 -> 출력 스트림을 얻어온다. 

  - `sendRedirect()` : 응답 객체가 가진 헤더 정보에 클라이언트가 다음 번에 어디로 갈지를 지정

    - **response.sendRedirect()를 실행될때 페이지를 이동하는 것이 아니라 페이지의 Header정보의 HTTP 상태코드(Status code)를 301로 바꾸어서 보내준다** 

    - 헤더를 바꾼다는 의미는 response.sendRedirect()이하의 모든 코드를 다 실행한다는 것! 

      

