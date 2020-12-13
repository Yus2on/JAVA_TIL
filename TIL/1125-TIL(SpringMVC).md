# Spring MVC

- Spring을 통해서 프로젝트를 설계할 때 비즈니스 레이어와 트랜잭션 레이어를 나눠서 설계 => **Two Layered Architecture** 

<br>

## 웹 개발 모델 

### Model 2 아키텍처 (MVC)

![image](https://user-images.githubusercontent.com/46306263/101595388-a113b380-3a36-11eb-881d-91ae72cf62e8.png)

- Model 1 방식은 JSP 와 JAVABeans로 나눠져서 JSP에 비즈니스로직과 디자인을 합쳐진 형태로 하나의 파일에 작성했었는데 이랬을 때 코드수정과 유지보수성이 어려워서 이를 해결하기 위해서 MVC 아키텍처를 적용했다.
- Model 2(MVC 아키텍처) 방식으로 비즈니스로직과 JSP를 나눴지만, 하나의 파일에 모든 비즈니스 로직이 들어가 있어서 코드의 양이 많아진다. 그래서 이런 기능들을 여러 구조로 나눈 것이 위 그림이다.

<br><br>

## MVC Framework 구조

![](https://user-images.githubusercontent.com/46306263/102013628-b40ae880-3d94-11eb-87f6-d4909b699ffc.png)

- DispatcherServlet 클래스 : 유일한 서블릿 클래스. 모든 클라이언트의 요청을 가장 먼저 처리하는 프론트 컨트롤러(Front Controller)
- HandlerMapping 클래스 : 클라이언트의 요청을 처리한 Controller 매핑
- Controller 클래스 : 실질적인 클라이언트의 요청 처리
- ViewResolver 클래스 : Controller 가 반환하는 View 이름으로 실행될 JSP  경로 완성 
- 클라이언트의 요청 -> 디스패처서블릿이 요청 받아서 web.xml 을 참고 -> HandlerMapping 을 통해서 요청한 컨트롤러로 매핑 -> 요청에 대한 기능 수행 -> 수행된 결과를 화면에 뿌려줄 View 클래스명 반환 -> ViewResolver 한테 다시 전달 -> ViewResolver 가 확인 -> 해당 View 파일 찾아서 클라이언트에게 응답 -> 해당 화면이 렌더링

<br><br>

## Spring MVC 적용

### DispatcherServlet 등록 (web.xml)

```xml
<servlet>
  <servlet-name>action</servlet-name>
  <servlet-class>
    org.springframework.web.servlet.DispatcherServlet
  </servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/config/presentation-layer.xml</param-value>
  </init-param>
</servlet>

<servlet-mapping>
  <servlet-name>action</servlet-name>
  <url-pattern>*.do</url-pattern>
</servlet-mapping>

```

- 디스패처서블릿에서 스프링컨테이너를 생성하는 이유 : 
  - 서블릿컨테이너에 등록할 수 있는 종류는 서블릿, 필터, 리스너 이 세가지만 Web.xml에 설정할 수 있다. 그래서 컨트롤러, 핸들러 매핑, 뷰리졸버 이런 클래스들을 서블릿컨테이너에 설정을 할 수가 없다.
  - 클라이언트의 요청을 수행하는 기능을 수행하는 컨트롤러나 이런 클래스들을 메모리에 띄워놔야 기능 수행이 가능하니깐 별도로 메모리에 띄울 수 있게 스프링 컨테이너에 로딩되는 xml에 빈 등록을 하면 메모리에 띄울 수 있으니깐 스프링 컨테이너가 필요한 것이다.

<br>

### Servlet Container와 Spring Container의 관계

![](https://user-images.githubusercontent.com/46306263/102013811-c76a8380-3d95-11eb-9a5c-ab5ea63e65e4.png)

- 직접 만드는 클래스를 Bean 으로 등록할 때 id를 변수명 규칙과 동일하게 작성해야 한다
- 하지만 스프링 컨테이너에서 제공하는 클래스를 Bean 등록할 때는 끝에 두 단어의 첫글자를 소문자로 변환 후 id로 설정해야 한다.
- 브라우저는 절대 서버가 관리하는 프로젝트의 WEB-INF 폴더에 접근할 수 없다 -> 따라서 브라우저가 직접 접근해서는 안되는 파일은 WEB-INF 폴더에 넣어두면 됨 
  - 서버에서 파일명으로 URL 접근하면 해당 파일을 찾을 수 없도록 에러가 뜬다.
- 스프링 컨테이너에서 로딩하는 파일이 `action-layer.xml` 로 고정이 되어있는데 파일명을 편하게 변경하고, Web.xml에서 달라진 파일명을 참조하도록 바꿀 수 있다.

<br><br>

## Spring MVC 흐름

![](https://user-images.githubusercontent.com/46306263/102013952-9a6aa080-3d96-11eb-9830-d7ee835f5de9.png)

### Spring MVC 동작 순서

- 서버가 실행되면 Servlet Container가 Web.xml을 로딩해서 생성이 된다.
- 기다리고 있다가 클라이언트로부터 요청이 오면 DispatcherServlet 객체를 생성한다
- 이때, init() 메서드가 딱 한번 실행되는데 내부적으로 XmlWebApplicationContext 스프링 컨테이너가 action-servlet.xml을 로딩해서 생성된다.
- action-servlet.xml에는 빈 등록이 되어있어서 객체들이 메모리에 떠서 요청에 대한 결과를 처리할 수 있게 된다.

<br>

### Dispatcher 와 View

![](https://t1.daumcdn.net/cfile/tistory/995747395AA9239A03)

- context.xml 파일 내 `prefix` 와 `suffix`  를 정해주면 Dispatcher 는 View 를 찾을 수 있다
- 위의 경우는 `/WEB-INF/views/ + 뷰의 이름 + .jsp` 
  - /WEB-INF/views/ 디렉토리 안에 있는 view 파일을 알려주는 것 

<br>

### Controller

![](https://t1.daumcdn.net/cfile/tistory/9938C94F5AA922BE2D)

- 스프링 MVC 프로젝트를 생성하면 Controller가 자동 생성됨

- HomeController.java 를 Controller 라고 인식하는 것은 `@Controller` 어노테이션 때문

  - 클래스에  `@Controller`  를 써서 해당 클래스를 메모리에 생성하고  Controller 객체로 인식하도록 함

  - Controller 를 POJO 로 코딩 가능 (= 인터페이스를 implements 하지 않고 파라미터 작성 자유)

    ```java
    @Controller
    public class BoardController {
      @Autowired
      private BoardService boardService; // 이 타입의 객체가 메모리에 없으면 애러 있으면 객체의 주소를 할당한다.
    }
    ```

<br>

### 클라이언트 화면

![](https://t1.daumcdn.net/cfile/tistory/990C53425AA923331E)

- DispatcherServlet 는 web.xml 에서 설정

- servlet mapping의 url-pattern -> `/` 으로 url 설정

- ` / ` 라는 url이 들어오면 Dispatcher 가 가져감 

- Dispatcher 는 controller를 찾기 위해 `component-scan`  사용 

  ```xml
  <context:component-scan base-package="com.rubypaper.biz" />
  ```

  - servlet-context.xml의 `<context:component-scan>` 에 의해서 컨트롤러의 패키지를 알려준다

- Dispatcher 가 `@RequestMapping` 이 붙은 메서드의 로직 수행 -> ViewResolver 를 통해 `/WEB-INF/views/ + home + .jsp` 찾아 화면 출력 

  - ![](https://t1.daumcdn.net/cfile/tistory/994F8D385AA9257B0E)
- `@RequestMapping("/getBoard.do")`를 메소드에 붙여주면 `/getBoard.do`로 요청이 들어올 때 바로 밑의 해당 메소드와 매핑시켜 메소드를 실행시킨다.
  - `@RequestMapping`이 주석 처리되어 있으면 스프링 컨테이너에서 해당 메소드를 인식하지 못한다.
  

<br>

### 요청 방식에 따른 @RequestMapping

```java
@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
```

- 안에 내용을 이렇게 변경 -> 요청 방식이 GET, POST 에 따라 다른 메소드 호출을 할 수 있다. (서블릿에서 doGet(),doPost() 방식과 같이)
- 이런 방식 적용 예시: 
  - 사용자가 로그인을 하고 어떤 물건을 구매할 때 구매 페이지로 가게 되면 로그인해서 등록 되어있는 사용자 정보 출력 페이지에 이용 가능. 아래 GET 부분에 set으로 값을 설정해놓고 실행시켜서 글 등록에 들어가게 되면, 아래 내용이 채워진 글 등록 페이지를 볼 수 있다.
- 매개변수로 받은 vo 객체는 자동으로 request 내장 객체에 등록된다.
- 따라서 최종적으로 실행되는 화면(jsp)에서 EL을 이용하여 값을 뿌릴 수 있다.
  - EL에서 request, session에 있는 데이터들을 확인해서 값이 있으면 그 값들을 가져오니까 

```java
@Controller
public class BoardController {
  @Autowired
  private BoardService boardService; // 이타입의 객체가 메모리에 없으면 애러 있으면 객체의 주소를 할당한다.

  // 글등록 화면 이동
  @RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
  public String insertBoardView(BoardVO vo) {

    vo.setTitle("200자 미만으로..");
    vo.setWriter("테스터");
    vo.setContent("2000자 미만으로 작성해주세요.");
    return "insertBoard"; // 포워드: 하고 띄워쓰기하면 안됨

    // jsp에ㅐ서 el로 해주면 boardVO로 받는다.
  }
  // 똑같은 insetboard.do 로 왔을대 get/post방식이냐에 따라서 다르게 동작시킴.
  // 메소드가 있고 없고의 차이때문에 오버로딩으로 식별은 되지만 이름을 다르게 해줌.

  // 글등록
  @RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
  public String insertBoard(BoardVO vo ) {
    boardService.insertBoard(vo);
    return "forward:getBoardList.do"; // 포워드: 하고 띄워쓰기하면 안됨
  }
}

```

<br>

### ModelAndView

- 검색 결과를 Session 에 담아서 값을 넘기면 안됨

  - 세션은 세팅 되면 서버가 내려가기 전까지 계속 메모리에 남아 값이 보내지게 되면 메모리 용량이 커지게되서 메모리 낭비.
  - Request에 검색결과를 보내줘야 하는데 ModelAndView에 검색결과를 저장하면 자동으로 request에 저장이 된다. (request는 response를 하면 소멸되니깐)

- addObject() 메소드에 KEY,VALUE 쌍으로 보내면 Request 객체에 똑같이 KEY,VALUE 쌍으로 저장이 된다.

- POJO로 작성한 코드라도 리턴값을 String 통일하는게 좋음

  -  ModelAndView 를 사용했을 때 String으로 통일을 할 수가 없어서 Model을 사용한다.

  ```java
  @RequestMapping("/getBoardList.do")
  public ModelAndView modelAndView(BoardVO vo,ModelAndView mav) {
    System.out.println("게시글 목록 기능 처리");
  
    if (vo.getSearchCondition() == null)
      vo.setSearchCondition("TITLE");
    if (vo.getSearchKeyword() == null)
      vo.setSearchKeyword("");
    // 절대 검색 결과는 세션에 저장해서는 안된다. 검색 결과는 request에 등록해야 한다!!
    // ModelAndView나 Model 객체에 검색 결과를 등록하면 자동으로 request에 등록해준다. 중요한 개념이다!!!! 
    // 그래야 세션을 남용하지 않는다.
    mav.addObject("boardList", boardService.getBoardList(vo));
    mav.setViewName("getBoardList");
  
    return mav;
  }
  ```

<br>

### Model

- ModelAndView와 똑같지만 반환값을 String으로 해줄 수 있다.
- View 사용할 수 없다.
- **검색 결과는 세션에 저장해서는 안된다.** 검색 결과는 **request에 등록**
- ModelAndView나 Model 객체에 검색 결과를 등록하면 자동으로 **request에 등록**해 준다. -> 그래야 세션을 남용하지 않음

```java
@SessionAttributes("board")
@Controller
public class BoardController {
  @Autowired
  private BoardService boardService; // 이타입의 객체가 메모리에 없으면 애러 있으면 객체의 주소를 할당한다.

  // 글 수정
  // @ModelAttribute는 세션에 "board"라는 이름으로 데이터가 등록되어있다면 그 객체를 vo변수에 바인딩해라 라는 의미이다. 없으면 패스
  @RequestMapping("/getBoardList.do")
  public String getBoardList(BoardVO vo,Model model) {
    System.out.println("게시글 목록 기능 처리");

    if (vo.getSearchCondition() == null)
      vo.setSearchCondition("TITLE");
    if (vo.getSearchKeyword() == null)
      vo.setSearchKeyword("");

    model.addAttribute("boardList", boardService.getBoardList(vo));
    model.addAttribute("search", vo);

    return "getBoardList";
  }
}
```



