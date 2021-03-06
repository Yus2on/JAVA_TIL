# TIL (Today I Learned)

## Test Code

* @RunWith는 스프링 컨테이너를 내가 만들 수 없고, 스프링에서 제공하는 것이니깐 조작을 할 수 없어서 조작할 수 있는 가짜의 컨테이너를 만들겠다는 의미
  * ()안에 SpringRunner.class가 있는데 스프링 컨테이너를 만들겠다는 것이고, 다른 Runner를 넣으면 그 러너의 컨테이너를 만들겠다는 의미이다.
* Junit5에서 @RunWith가 @ExtendWith로 바뀌었다.
* @SpringBootTest 안에 @ExtendWith가 포함되어 있다. ( =중복해서 쓰지 않도록 주의)
* @SpringBootTest는 전체를 테스트하는 통합테스트이고, @SpringBootTest 말고도 여러 단위테스트가 존재
  * 그 중 @WebMVCTest가 있는데 이건 MVC를 위한 테스트 -> Controller에 대한 테스트가 가능 ( 역시 @ExtendWith가 포함, 간접적으로@SpringBootTest를 상속)

<br>

## 객체지향의 5원칙 (SOLID)
* SRP(단일 책임 원칙) : 모든 메소드나 클래스는 하나의 일만 한다는 의미
  * 회원 정보에 대한 클래스는 회원 정보에 대한 것만 처리해야 하며, 가입하기 메소드가 있다면 회원 가입 기능에 대해서만 동작해야한다.
  * 설계를 잘한 프로그램은 기본적으로 새로운 요구사항과 프로그램 변경에 영향을 받는 부분이 적다.( =응집도는 높이고 결합도는 낮은 프로그램)
  * 한 클래스의 기능이 많아지면 내부에 함수끼리 강한 결합이 발생할 가능성이 높아지고, 유지보수 비용이 증가 -> 기능을 분리시킬 필요가 있다.

* OCP(개방-폐쇄 원칙) : 기존의 코드를 변경하지 않고, 기능을 수정하거나 추가할 수 있도록 설계해야 한다.
  * 자주 변경되는 내용은 수정하기 쉽게 설계하고, 변경되지 않아야 하는 것은 수정되는 내용에 영향을 받지 않게 하는 것.
  * 그래서 인터페이스를 사용한다.

* LSP(리스코프 치환 원칙) : 자식클래스는 부모클래스에서 가능한 행위를 수행할 수 있어야 한다
  * 상속구조를 잘 가져가야한다. 하위 클래스에서 상위클래스를 위반하면 로직이 피곤해진다.
  * 부모 클래스와 자식 클래스 사이의 행위에는 일관성이 있어야 한다.
    * 부모 클래스의 객체 대신 자식 클래스의 객체를 사용해도 문제가 없어야 한다.
    * 도형 클래스가 둘레, 넓이, 각을 가지고 있을 때, 사각형이 도형 클래스를 상속 받으면 둘레, 넓이, 각을 가지고 있으니 상속이 잘 이루어진 것
    * 하지만 원형은 둘레, 넓이는 가지고 있지만 각을 가지고 있지 않으니 일관성이 유지되지 않아서 좋은 설계방법이라고 할 수 없다.

* ISP(인터페이스 분리 원칙) : 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다. (= 하나의 일반적인 인터페이스 보다는 여러개의 구체적인 인터페이스로 나누라는 의미)
  * 결제시스템이 있을 때, 하나의 결제 인터페이스 안에 카드결제, 현금결제, 기프티콘 결제 메소드가 있다고 하자
  * 일반적인 결제 상황에서는 위의 3가지 기능들 모두 가능해서 하나의 인터페이스를 사용해도 되지만 온라인 결제라는 것이 추가된다면? 
  * 온라인상에서는 현금결제가 불가능하니깐 결제 인터페이스를 구현한다면 사용하지 않는 기능에 대해서 영향을 받게 되는 것이니 좋은 설계가 될 수 없다.
  * 그래서 각 카드, 현금, 기프티콘 결제에 대한 인터페이스를 각각 만들어서 필요한 클래스에서 인터페이스는 다중으로 implement할 수 있으니깐
    implement하게 하는 것이다.

* DIP(의존 역전 원칙) : 의존관계를 맺을 때, 변화하기 쉬운 것 보단 변화하기 어려운 것에 의존해야 한다는 원칙
  - 변화하기 쉬운것은 구체적인 것(= 클래스)을 말하고, 변화하기 어려운 것은 추상적인 것(= 인터페이스, 추상클래스)을 말한다.
  - 의존관계를 맺을 때, 인터페이스를 사용해서 느슨하게 연결해야 한다.

<br>

### 프로그래밍 기본 용어
* Null safe 
  * 코딩방식에 대한 이야기로 리턴되는 값이 null이 아닌 걸 보장해주는 것이다.
  * 메소드의 반환값이 String 이면 반환값의 맞게 String 타입으로 반환해야한다
  * 자바에선 Optional을 사용하여 null값을 예방 할 수 있다.
* Thread safe 
  * 스레드간의 결합이 일어날 때 안전성이 보장되어야 한다.
  * 멀티스레드 프로그래밍에서 함수, 변수, 객체 등이 여러 스레드로부터 동시에 접근이 이루어져도 프로그램의 실행에 문제가 없다는 것을 의미.
  * 각 스레드에서 함수의 수행 결과가 의도한대로 나와야 하고, 제일 좋은 방법은 자원을 공유하지 않는 코드를 작성하는 것.
  * StringBuilder는 멀티스레드 상태에서 안전하지 않아서 **멀티스레드에선 StringBuffer를 사용**한다.
  * StringBuilder는 싱글스레드에서 StringBuilder와 똑같이 동작하고 Syncroniszed가 내부 메소드에 선언되어 있어서 스레드간의 결합이 일어날 때 안전성을 보장한다.
* String vs StringBuilder
  * 스트링은 Immutable 객체이고, Singleton으로 동작해서 `String str = "test" + "String" + "!!!"` 일 때, `+` 연산자를 만나 새로운 객체가 메모리에 올라가서 "test"가 생기고 "testString", "testString!!!"이 생긴다.
  * 그래서 합칠 때 메모리를 많이 잡아먹게 되고 연산속도가 떨어진다.
  * StringBuilder 는 append() 를 쓰면 하나의 문자열로 메모리에 생성된다.
  * 이런 차이 때문에 문자열을 합칠 때 StringBuilder를 선호했지만, 최근 버전에서는 `+`연산자로 String을 합쳐도 컴파일 과정에서 StringBuilder로 변환을 해줘서 큰 차이가 없다.
* Immutable 과 final
  * final을 사용하면 한번 할당된 값을 재할당 할 수 없다. 
  * Immutable은 값이 변경되는 것을 막는 것 -> 재할당할 수 있어 다른 메모리의 값을 참조할 수 있지만 한번 메모리에 정해진 값을 변경하는 것을 막는 것이다.

<br>

## Lombok
* Lombok에서 중요한게 ToString(), HashCode()
* `@EqualsAndHashCode` 
  * 대체로 사용하는 편이 좋다. 
  * 해쉬코드가 필요한 이유는 객체의 값 같으면 같은 객체로 봐야하기 때문에 객체값을 비교해서 값이 같다면 동일한 해쉬코드 값을 갖게해서 같은 객체로 오버라이딩해주기 위해서.
* `@RequiredArgsConstructor` 
  * 초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
  * 의존성 주입 편의성을 위해서 사용되곤 한다. 
* `@NoArgsConstructor` : 파라미터가 없는 기본 생성자를 만들어주는 것이다.
* `@AllArgsConstructor` : 필드에 맞춰 생성자를 파라미터를 넣어서 만들어 준다.
* 패스워드를 ToString에서 제외시킬 때 `@ToString.Exclude` 이렇게 사용하는걸 추천 
  * ToString에 사용할 수 있지만 거기에는 Stringd으로 선언되기 때문에 여기서 필드명을 바꾸게 되면 인식하지 못할 수 있음
  * `private String password;` 유저는 똑같은 패스워드를 쓰는 경우가 많아서 패스워드가 해킹 당하면 모든 사이트에 비슷하게 사용해서 같이 털린다. -> 패스워드는 평문으로 저장 못하게 되어있다. (= 단방향 암호화)
  * 복호화가 되지 않는 암호화를 한다.
  * 계좌번호나 전화번호는 암호화를했지만 키가 있으면 복호화 가능. (= 양방향 암호화)
  * 회사에서도 비밀번호를 알 수 없다 -> 사용자가 비밀번호를 넣으면 암호화 로직에 똑같이 태워서 db에 있는 비밀번호와 맞는지 확인
  * 로그에도 패스워드가 나오면 안되니까 @Exclude 사용
* `@Builder` 
  * 빌더를 하게되면 생성자는 idea에서 파라미터값들이 표시가 되어서 편한데 나열되면 작성하기 어려움
  * 그래서 builder()가 제공되서 빌더 패턴으로 작성 -> `todo.builder().id().title().build()` 
  * 특정필드에 특정값을 넣는게 명확 -> 빌더를 사용하는게 안전하다
  * 중간에 필드의 작성순서를 바꾸게 되면 빌더는 상관없는데, 일반 생성자에선 위치에 맞게 순서를 작성해줘야 함 (아니면 에러)
  * 빌더 메소드 이름도 변경 가능 ->Todo.Maker() 식으로 
