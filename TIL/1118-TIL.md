## HTTP(Hyper Text Transfer Protocol)

### HTTP란

- 웹에서 가장 많이 사용하는 웹 클라이언트(Browser) 와 서버간의 통신 규약 
- 클라이언트가 HTTP 요청 (Request)을 만들어 서버에게 보내면, 서버는 클라이언트의 HTTP 요청 (Response)에 응답한다.
  	1. 브라우저에서 버튼을 누르고 링크를 클릭하거나 직접 URL 입력 등 요청
   	2.  http 요청 프로토콜 생성 -> 헤더와 바디에 정보를 담고 요청 프로토콜을 서버가 받아서 해석하고 실행 
   	3. 브라우저에 응답 프로토콜 -> 브라우저는 응답 프로토콜을 분석해 화면에 출력 
- HTTP를 통해 파일을 요청할때, 클라이언트는URL 파일들을 제공해야 하며, 웹 서버는 최소한의 에러 메시지를 포함하여 모든 HTTP 요청에 응답해야 한다. 

![](https://user-images.githubusercontent.com/46306263/99880547-52ed6a80-2c57-11eb-8a89-909b0c7e5c65.png)

<br>

<br>

## HTTP Message

- 서버와 클라이언트 간에 데이터가 교환되는 방식

- 메시지 타입은 두 가지로, 클라이언트가 서버로 전달해서 서버의 액션이 일어나게끔 하는 요청(*request*) 메시지와 요청에 대한 서버의 답변인 응답(*response)* 이 있다.

- HTTP 요청과 응답의 구조는 시작 줄(Start-line), 헤더(Header), 본문(Body)으로 구성 되어있다.

  - Start-line : 실행되어야 할 요청, 요청 수행에 대한 성공 실패
  - Header    : 요청에 대한 설명, 메시지 본문에 대한 설명
  - CRLF         : 요청에 대한 모든 메타 정보가 전송되었음을 알리는 빈 줄 (Blank Line) 삽입
  - Body         : 요청과 관련된 내용(HTML 폼 콘텐츠 등), 응답과 관련된 문서(Document). 본문의 존재 유무 및 크기는 첫줄과 헤더에 명시

- 시작 줄과 헤더를 묶어 *헤드(Head*) , HTTP 메시지의 페이로드는 *본문(body)* 라고 명시 

  

  ![Requests and responses share a common structure in HTTP](https://mdn.mozillademos.org/files/13827/HTTPMsgStructure2.png)



<br>

### HTTP Request Message

#### 요청 메시지 형식

```
<HTTP 메서드> <요청URL> <버전>
<헤더>

<엔티티 본문>
```

<br>

#### Start-line

- **무엇을 해야하는지** 알려준다.
- 서버가 특정 동작을 취하게끔 만들기 위해 클라이언트에서 전송하는 메시지
- 아래 세 가지 요소로 이루어져 있다 
  - HTTP 메서드 ([`GET`](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/GET), [`PUT`](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/PUT),[`POST`](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/POST)). 서버가 수행해야 할 동작을 나타 냄.
  - URI(Uniform Resource Identifier) 정보 (= URL에서 HTTP프로토콜, 호스트명, port 번호를 제외한 것)
    - 포맷에 여러가지가 있지만 origin 형식, 끝에 `'?'`와 쿼리 문자열이 붙는 절대 경로가 가장 일반적인 형식
  - 요청에 사용된 프로토콜의 이름과 HTTP 버전. 버전에 따라 요청 메시지 구조나 데이터가 다를 수 있어서 명시함
- `CRLF` 는 캐리지 리턴(`\r`)과 개행문자(`\n`) 로 구성된 두 글자의 줄바꿈 문자열이다.
  - 캐리지 리턴(CR, Carriage Return): Window OS에서 개행문자로 사용. 커서의 위치를 맨 앞으로 이동한다.
  - 라인 피드(LF, Line Feed): Linux와 macOS에 개행문자로 사용. 커서를 한 칸 아래로 이동한다. (새로운 행 추가)

#### Header

- 0개에서 1개 혹은 여러개의 HTTP 헤더가 온다.

-  key : value 로 이루어져 있다. 대소문자 구분없는 문자열 다음에 콜론(`':'`) 사용.

- 헤더 필드, 헤더 블록, 헤더 등으로 명시 가능

- Request-header (요청 헤더)

  - 요청의 내용을 좀더 구체화시켜 부가적인 정보를 제공 
  - 예) Host, User-Agent, From, Cookie, Referer, If-Modified-Since, Authorization, Origin, Accept

- General-header (일반 헤더)

  - 요청과 응답 양쪽 모두에 나타날 수 있다
  - 예) Date, Connection, Cache-control …

- Entity-heard

  - `Content-Length` (= 콘텐츠 문자열의 문자 수 )와 같이 본문이 적용된 내용에 관련된 헤더. 
  - 요청 내에 본문이 없는 경우 entity 헤더는 전송되지 않는다
  - 예) Content-Type, Content-language, Content-Encoding, Content-Length, Content-Location, Content-Disposition, Content-Security-Policy, Location, Last-Modified, Transfer-Encoding

  ![Example of headers in an HTTP request](https://mdn.mozillademos.org/files/13821/HTTP_Request_Headers2.png)

#### Body

- 웹 서버로 전달할 데이터를 가지고 있다.
- 시작줄과 헤더와 달리 이진 데이터를 포함할 수 있다. (= 이미지, 텍스트, 비디오 등 가능)
- `GET`, `HEAD`, `DELETE` , `OPTIONS`처럼 리소스를 가져오는 요청은 보통 본문이 필요 없다 
- HTML 폼 데이터를 포함하는 `POST` 요청일 경우에 데이터가 존재

<br>

### HTTP Response Message

#### 응답 메시지 형식

```
<버전> <상태 코드> <사유 구절>
<헤더>

<엔티티 본문>
```

<br>

#### Start-line

- 요청에 대한 `응답 상태`, **무슨 일이 일어났는지** 말해준다.

- 마찬가지로 세 가지 요소로 구성

  - HTTP 버전
  - 상태 코드 : 요청의 성공 여부 표시. 숫자로 된 코드를 반환. `200`, `404` , `405`  혹은 `500` .  
    - `404`: 서버가 요청받은 리소스를 찾을 수 없다는 것. (서버 내 서블릿 엔진, web.xml 내에 호출하지 않은 파일 )브로큰 링크(broken link) 또는 데드 링크(dead link) 라고 부른다. 
    - `405 `: 요청방식 메서드가 없을때 (서버가 지원하지 못 한다는 메시지 출력.) 각 방식에 따라 메서드를 가지고 있어야함 (doGet() / doPost())
    - `500`: 서버 에러 응답. 실행 오류  
  - 상태 텍스트 : 사유 구절. 상태 코드와 1:1로 대응. 상태 코드의 사람이 이해하기 쉬운 버전. 짧고 간결하다.
    - HTTP/1.0 이전에는 응답에 응답줄이 들어있을 필요가 없었다.

- 모든 필드는 **공백** 으로 구분된다.

  ```
  HTTP/1.1 400 Not Found.
  	// -> HTTP 버전은 1.1 이고 상태코드 400와 문자열(= 상태 텍스트, 사유구절) 반환
  
  HTTP/2.0 200 OK
  	// -> HTTP 버전 2.0 상태코드 200, OK 문자열 반환 
  ```

#### Header

- 요청 헤더와 동일 

#### Body

- 클라이언트로 데이터를 반환. 
- 모든 요청 메시지에 본문이 들어가진 않는다.
- [`201`](https://developer.mozilla.org/ko/docs/Web/HTTP/Status/201), [`204`](https://developer.mozilla.org/ko/docs/Web/HTTP/Status/204)과 같은 상태 코드를 가진 응답이거나 간단한 문서를 가져오는 데에는 보통 본문이 없다. 

<br>

<br>

### HTTP 메서드(Method)

| 메서드  |                             설명                             | 요청 메시지 내 바디 존재 |
| :-----: | :----------------------------------------------------------: | :----------------------: |
|   GET   |      주로 서버에게 데이터를 요청. 이미지, url입력 방식       |            X             |
|  HEAD   |  GET처럼 행동하지만, 서버는 응답으로 **헤더**만을 돌려준다.  |            X             |
|  POST   | 클라이언트가 서버에 데이터를 새로 추가할 때, 서버가 처리해야 할 데이터를 보낸다. |            O             |
|   PUT   | POST와 유사한 전송 구조. 주로 서버에 이미 존재하는 데이터를 수정(UPDATE)한다. |            O             |
| DELETE  |     서버에게 요청 URL로 지정한 리소스를 삭제할 것을 요청     |            X             |
| OPTIONS | 웹 서버에게 여러 가지 종류의 **지원 범위에 대해 물어본다**.<br/>응답메세지 헤더에 `Allow` 필드를 포함해서 돌려준다 |            X             |
|  TRACE  | 자신의 요청이 서버에 도달했을 때 어떻게 보이게 되는지 알려준다. |            X             |

- 서버마다 자기만의 메서드가 존재할 수 있다
- 이러한 메서드를 `확장 메서드` 라고 한다 

<br>

#### GET

- GET은 가장 흔히 쓰이는 메서드로 주로 서버에게 리소스를 달라고 요청할 때 쓰인다.
- 입력데이터를 URL에 붙여서 전송하기 때문에 요청 메시지 내 헤더에 바디가 없다
- POST에 비해 보안성이 떨어진다 

![GET Method](https://media.vlpt.us/post-images/codemcd/f03c8e00-e267-11e9-a634-d9d33e59b626/HTTP3-7.png)

#### HEAD

- GET처럼 행동하지만, 서버는 응답으로 **헤더**만을 돌려준다.

- 엔티티 본문은 절대 반환되지 않는다. 

- HEAD 를 사용하는 이유 :

  - 리소스를 가져오지 않고도 그에 대해 무엇인가(타입 등) 를 알아낼 수 있다.
  - 응답의 상태 코드를 통해, 개체가 존재하는지 확인할 수 있다.
  - 헤더를 확인하여 리소스가 변경되었는지 검사할 수 있다.
  - 큰 용량의 리소스를 다운로드 받을지 말지 결정하기 위해서 사전 요청하는 용도로 사용할 수 있다.

  ![HEAD Method](https://media.vlpt.us/post-images/codemcd/067248e0-e268-11e9-a4c2-fdfd8195e079/HTTP3-8.png)

#### POST

- 서버에 입력 데이터를 전송하기 위해 설계되었다.

- GET 처럼 사용할 수 있지만 메시지 내 바디가 있어서 원하는 만큼 데이터를 넣을 수 있다 (= 이미지 등 )

- HTML의 form을 지원하기 위해 흔히 사용된다

- request의 body 타입은 Content-Type 헤더(header)에 따라 결정된다.

  ![POST Method](https://media.vlpt.us/post-images/codemcd/47fc1610-e268-11e9-a4c2-fdfd8195e079/HTTP3-10.png)

#### PUT

-  서버에 이미 존재하는 데이터를 업데이트할 때 사용

- 서버가 요청의 본문을 가지고 요청 URL의 이름대로 **새 자료 생성**

- 이미 URL이 존재한다면, 본문을 사용해서 **교체**

- 데이터를 변경할 수 있는 메서드이기 때문에 서버 입장에서는 위험할 수 있다.

- POST 와 PUT 의 차이는 **멱등성** 이다. 

  - PUT으로 새 리소스를 생성하고 동일한 내용으로 PUT을 리소스에 요청해도 두 번째는 이미 존재하고 동일한 내용이므로 결과는 같다.
  - 이미 존재하는 리소스에 PUT을 보낼 경우 동일한 내용으로 몇 번을 보내더라도 동일한 내용으로 상태가 저장되므로
    리소스 상태는 변하지 않는다.

  ![PUT Method](https://media.vlpt.us/post-images/codemcd/308094c0-e268-11e9-a4c2-fdfd8195e079/HTTP3-9.png)

#### OPTIONS

- 웹 서버에게 여러 가지 종류의 **지원 범위에 대해** 물어본다

- 서버에게 특정 리소스에 대해 어떤 메서드가 지원되는지도 물어볼 수 있다.

  <img src="https://blog.kakaocdn.net/dn/c5Sc4y/btqwonDlowM/LhJZKMPeXPWSJnjBrgVho1/img.png" alt="OPTIONS Method" style="zoom:150%;" />



#### TRACE

- 자신의 요청이 서버에 도달했을 때 어떻게 보이게 되는지 알려준다.
- 클라이언트에서 TRACE 메시지를 보내면 -> 중간에 프록시 같은 애들이 헤더 쪽에 값을 넣어주고 -> 서버쪽에서 루프백 (loopback) 진단 후 -> 본문에 내용을 넣어서 클라이언트
- 주로 진단을 위해 사용된다. (= 디버깅용)
  - 요청이 의도한 요청/응답 연쇄를 거쳐가는지 **검사**할 수 있다.
  - 클라이언트가 요청/응답 연쇄를 따라가면서 **자신이 보낸 메세지가 망가졌거나 수정되었는지, 만약 그렇다면 어떻게 변경되었는지 확인**할 수 있다.





<img src="https://blog.kakaocdn.net/dn/c5Sc4y/btqwonDlowM/LhJZKMPeXPWSJnjBrgVho1/img.png" alt="TRACE Method" style="zoom:150%;" />





<br>

<br>

# Reference.

- [feel5ny.github.io HTTP 메시지](https://feel5ny.github.io/2019/08/15/HTTP_003_01/)

- [[MDN] HTTP](https://developer.mozilla.org/ko/docs/Web/HTTP)

- [HTTP 요청과 응답](https://medium.com/webeveloper/http-%EC%9A%94%EC%B2%AD%EA%B3%BC-%EC%9D%91%EB%8B%B5-2209bc82f239)

  