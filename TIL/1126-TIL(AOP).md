# TIL (Today I Learned)

## 인텔리제이 프로젝트 설정
1. Java 프로젝트 생성
2. 프로젝트 명 우클릭 -> Add FrameWork Support
3. JavaEE -> Web 클릭 -> Ok
4. 파일 Project Structure 라이브러리 이동 ->  `+` 키로 추가하고 싶은 라이브러리 추가
5. Artifact -> WEB-INF 밑에 lib 폴더 생성 ->  `+` 로 file 클릭 -> 라이브러리 넣기
6. resource, test 폴더를 만들 때는 기본화면에서 폴더 추가 -> project structure에서 moudles 로 이동 -> 해당 프로젝트 클릭하면 그 프로젝트 하위 폴더들 -> resource -> mark as -> Resources, test는 test로 설정

<br>

## AOP 용어
* **조인 포인트 (Joinpoint)** : 어드바이스를 적용해야 하는 위치. 필드, 메소드만 해당된다.
* **포인트 컷 (Pointcut)** : 비즈니스로직이 있는 객체, 어느 비즈니스 로직이 있는 객체에 적용할 것인지를 말한다.
* **어드바이스(Advice)** : 횡단 관심 로직을 따로 만들어 놓은 객체
* **위빙(Weaving)** : 어드바이스를 포인트 컷에 적용하는 행위
* **애스팩트(Aspect)** : 포인트 컷과 어드바이스를 합친 객체

```xml
<aop:config>
   <aop:pointcut id="allPointcut" expression="execution(* rubypaper.biz..*Impl.*(..))"/>
   <aop:aspect ref="log">
     <aop:before method="printLog" pointcut-ref="allPointcut"></aop:before>
   </aop:aspect>
</aop:config>
```
* pointcut이 비즈니스 로직 실행 -> 이 비즈니스 로직 실행 전에 (aop:before) aspect의 참조 되어있는 LogAdvice 클래스의 printLog 메소드를 실행시킨다.
* 클래스는 각각의 비즈니스 로직만을 구현할 수 있게 설계 해야 한다
  * 그 외의 부가적인 기능과는 연결고리가 없게, 결합도가 떨어지게 설계 필요 
* Service 클래스는 비즈니스 로직을 중점적으로 개발
* DAO클래스는 DB연동에 관한 로직만을 갖고 있어야 함 
```java
package rubypapper.biz.user;
import org.springframework.context.support.GenericXmlApplicationContext;
import rubypaper.biz.user.UserDAO;
import rubypaper.biz.user.UserService;
import rubypaper.biz.user.UserServiceImpl;
import rubypaper.biz.user.UserVO;
public class UserServiceTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
        UserService userService = (UserService) container.getBean("userService");
      
        if (userService != null){
            System.out.println("---> UserService LookUp 성공");
        }
      
        UserVO vo = new UserVO();
        vo.setId("aa");
        vo.setPassword("aa");
      
        UserVO user  = userService.getUser(vo);
        // userService에서 비즈니스로직을 수행하는 부분이니 userService를 통해서
        // DB와 연동을 하는 DAO를 호출해서 사용하는 것이다.
        // DAO는 DB연동 기능을 주 역할을 하는 클래스이기 때문에 바로 접근보다는 Service 클래스를 통해서 접근한다.
        System.out.println(user.getName() + "님 환영합니다.");
    }
}
```