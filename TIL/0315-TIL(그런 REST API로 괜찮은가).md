# TIL(Today I Learned)

- 슬라이드 : https://slides.com/eungjun/rest
- DEVIEW 2017 : https://tv.naver.com/v/2292653

<br><br>

## REST

- **REpresentational State Transfer**
- 컴퓨터 시스템 간 상호운용성을 제공하는 방법

<br><br>

## Rest API 의 시작

### WEB (1991)

- Q. 어떻게 인터넷에 정보를 공유할 것인가?
- **A. 모든 정보들을 하이퍼 텍스트로 연결해서 제공하자.**
  - html 형식으로 정보를 제공하고, 그 정보들의 식별자로 url를 만들고, 그 정보들을 전송하는 방법으로 HTTP 라는 프로토콜을 생성 

<br>

### HTTP/1.0 (1994-1996)

- Roy T. Fielding: "How do I improve HTTP without breaking the Web?"
- Roy Fielding 은 기존에 구축되어 있는 Web Server와 호환성 문제가 생기는 것을 피하기 어려울 것이라고 생각 -> 어떻게하면 기존에 구축되어 있는 Web을 망가뜨리지 않고 Http를 증보시킬 수 있을까?
  - 해결책으로 ` HTTP Object Model ` (= 1998, REST 라는 이름으로 발표하게 됨 )
  - Architectural Styles and the Design of Network-based Software Architectures (2002) REST 논문 정의 

<br>

### API

- XML-RPC (1998) : Microsoft 가 원격으로 다른 시스템의 메소드를 호출할 수있는 프로토콜을 만듦 (= 이것이 나중에 SOAP)

- Salesforce API (2002) : Salesforce 란 회사에서 API 를 공개. 인터넷에 거의 최초로 공개 된 API -> 너무 복잡해서 인기가 없었음 

  ![Salesforce API (2002)](https://blog.kakaocdn.net/dn/cJ9B5e/btqxDUmlUU6/K4h1hKKZHiIAXbTLvzklq0/img.png)

  ![Salesforce API](https://blog.kakaocdn.net/dn/bwmUiF/btqxB62muh9/bZ7Fiaz0YE33vYKnMbBH3K/img.png)

- Flickr API (2004) : 여러가지 형태 (SOAP, REST) 로 만들었음. SOAP 에 비해 REST 가 훨씬 간다함

  ![Flickr API (2004) ](https://blog.kakaocdn.net/dn/dDHJtb/btqxDVr2rTj/YVXPuxYLRBp8hBjh6IGuWk/img.png)

<br>

### SOAP과 REST 의 *느낌적인* 비교와 결과

- SOAP

  - 복잡하다
  - 규칙이 많다
  - 어렵다

- REST

  - 단순하다
  - 규칙이 적다
  - 쉽다

- REST의 인기 급상승으로 AWS 가 자사 API의 사용량의 85%가 REST라고 밝힘 (2006) + Salesforce 가 REST API 추가 (2010)

  ![REST 의 승리](https://blog.kakaocdn.net/dn/95vid/btqxDtCxyWI/senTl0ARgKH9n0eks8i5tk/img.png)

<br>

### CMIS (2008)

- CMS 를 위한 표준
- EMC, IBM, MS 같은 큰 기업이 참여하여 함께 작업
- **REST 바인딩 지원** -> Roy Fielding : "No REST in CMIS" (= REST를 만든 로이 필딩은 CMIS에 REST 는 없다.)

<br>

### MS 의 REST API 가이드라인 발표 (2016)

- Roy Fielding: 이것도 REST API가 아니다. 이건 HTTP API 다.
- **"REST API 를 위한 최고의 버저닝 전략은 버저닝을 안하는 것"**
- **"REST API must be hypertext-driven"**

<br><br>

## REST API?

- REST 아키텍쳐 스타일을 따르는 API
- REST 란 분산 하이퍼미디어 시스템(ex. 웹)을 위한 *아키텍쳐 스타일( = 제약 조건의 집합)*

<br>

## REST의 구성

- REST는 자원(Resource), 행위(Verb), 표현(Representation)으로 구성되어 있다.
- **자원(Resource) - URI**
  - 모든 자원에는 고유한 ID가 존재하고, 이 자원은 Serber에 존재한다.
  - 자원을 구분하는 ID는 HTTP다.
  - Client는 URI를 이용해서 자원을 Server에 요청한다.
- **행위 (Verb) = HTTP Method**
  - HTTP 프로토콜의 메소드를 사용한다.
  - HTTP 프로토콜은 GET, POST, PUT, DELETE와 같은 메서드를 제공한다.
- **표현 (Representation)**
- Client가 자원의 상태에 대한 조작을 요청하면 Server는 이에 적절한 응답(Representation)을 보낸다.
- REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 나타내어 질 수 있다.

<br>

### REST를 구성하는 스타일

- client-server: Client와 Server의 역할이 명확하게 구분되어있어야한다. 의존성을 낮춘다.
- stateless (무상태성): Server는 Client 의 상태정보를 계속 가지고있을 필요가 없다. Server는 오는 요청에 대한 응답만 할 뿐.
- cache (캐시처리 기능): 캐시사용이 가능해야한다.( Expire, Cache-Control, ETag 등의 헤더값)
- **uniform interface** (**통일된 인터페이스** )
- layered system (계층형 구조)
- code-on-demand (optional): 서버에서 코드를 클라이언트로 보내서 실행할 수 있어야 한다 (= Javascript)

<br>

### Uniform Interface 의 제약조건

- 자칭 REST API라고 알려진 모든 것들이 대부분 맨 아래 두가지 제약조건은 지키지 못하고 있다고 한다.

  1. identification of resources (리소스가 uri로 식별되어야 한다)
  2. manipulation of resources through representations (representation 전송을 통해서 리소스를 조직해야 한다. → 리소스를 수정하거나 만들 때 HTTP 메세지에 표현을 담아서 전송을 해서 달성해야 함)
  3. **self-descriptive messages (메세지는 스스로를 설명해야 한다, 자체 표현 구조)**  → REST API 메시지만 보고도 이를 쉽게 이해할 수 있는 자체 표현 구조로 되어있다는 것.

  ```json
  // GET 메서드로 보내는 요청인데 이 HTTP 메서드는 목적지가 빠져있다
  GET / HTTP/1.1  
  
  // 목적지(도메인)를 추가하면 self-descriptive
  GET / HTTP/1.1  
  Host: www.example.org
  ```

  ```json
  // 응답 메시지 -> self-descriptive 하지 않음
  // 왜냐면 클라이언트가 어떤 문법으로 작성된 건지 모르기 때문에 해석을 할 수 없음 
  HTTP/1.1 200 OK
  [
    {
    	"op": "remove",
      "path": "a/b/c"
    }
  ]
  
  
  // self-descriptive 해주려면 Content-Type 헤더를 추가해주고, 
  // 명세를 찾아가서 메시지를 해석하면 올바르게 이 메시지를 이해할 수 있어짐
  HTTP/1.1 200 OK
  Content-Type: application/json-patch+json
  [
    {
    	"op": "remove",
      "path": "a/b/c"
    }
  ]
  ```

  4. **hypermedia as the engine of application state (HATEOAS) (애플리케이션의 상태는 Hyperlink를 이용해 전이되어야 한다. 애플리케이션의 상태 전이)**

<br>

### HATEOS

- 어플리케이션의 상태가 하이퍼링크를 통한 상태 이동(전이)이 일어나야 한다.
  - `<a>` 태그를 통해 다음 상태로 전이될 수 있도록 제공.
  - json 으로 표현할 땐 응답에는 Link 헤더로 제공 가능. Link 헤더는 이 리소스와 연결되어 있는 다른 리소스를 가리킬 수 있는 기능을 제공하는 헤더. (표준)
  - 예를 들어, 게시글 목록페이지에서 링크를 통해 > 게시글 하나 > 또, 거기서 수정 페이지 등으로 상태 전이가 가능
-  링크가 없으면 상태 전이가 가능하지 않다.
- 왜? **HATEOS 는 애플리케이션 상태 전이의 late binding을 가능하게 하기 때문에 필요하다.**
- 어디서 어디로 전이가 가능한지 미리 결정되지 않는다. 어떤 상태로 전이가 완료되고 나서야 그 다음 전이될 수 있는 상태가 결정된다. 
- 링크는 동적으로 변경될 수 있다. 언제나 서버가 마음대로 바꿀 수 있음.

<br>

### 왜 Uniform Interface?

- **독립적 진화**
  - 서버와 클라이언트가 각각 독립적으로 진화한다.
  - 서버의 기능이 변경되어도 클라이언트를 업데이트 할 필요가 없다. -> REST 를 만들게 된 계기 (How do I improve HTTP without breaking the Web?)