# AOP(Aspect oriented Programming)

- 관점 지향 프로그래밍.
- OOP 의 단점을 극복할 수 있도록 도와주는, OOP를 OOP 답게 더 강화시켜주는 프로그래밍 기법 (= OOP 의 대체 개념이 아님 )
- 여러 객체에서 공통적으로 작성해야 하는 부분들을 **횡단 관심**이라고 하는데, 이 횡단 관심을 제거하여 핵심 관심(= 비즈니스 로직)만 집중할 수 있도록 하고자 하는 프로그래밍 기법이 AOP이다.

<br><br>

## 핵심 관심(Core Concerns) 과 횡단 관심(Crosscutting Concerns)

![](https://user-images.githubusercontent.com/46306263/101586724-e8457880-3a25-11eb-9e73-3b9646d1f750.png)

- 위의 그림처럼 각 기능을 하는 비즈니스 메소드가 있다고 할 때, 그 메소드의 비즈니스 로직 말고 로그 출력, 예외처리, 트랜잭션 핸들하는 등의 코드가 존재 -> 문제는 해당 메소드들은 비즈니스 로직만 존재해야 하는데 다른 기능들이 들어가 메소드의 응집도 하락
- 응집도 하락 -> 코드 분석 성능 하락 -> 똑같은 코드들을 여러 메소드들에도 똑같이 작성해야 하니깐 코드 낭비
- 이런 점을 해결하기 위해 AOP를 이용하여 실제 비즈니스 로직을 제외한 여러 곳에서 사용되는 로직을 분리, 각 기능을 하는 독립된 클래스 생성 + 필요한 여러 메소드들에서 사용
- 핵심관심코드(=비즈니스로직) 횡단관심 코드(=비즈니스 로직 외 메소드마다 반복되는 로직)

<br><br>

## AOP XML 설정

```java
package com.rubypapper.biz.common;

public class LogAdvice {
  
  public void printLog() {
    System.out.println("<사전 처리> 비즈니스 로직 수행 전 동작");
  }
  
}
```

- LogAdice 클래스 생성 -> 횡단관심 코드 분리 -> 이렇게 작성을 해놓으면 컨테이너가 자동으로 클래스 명에 Impl이 들어가 있는 모든 클래스의 메소드들에 `printLog()` 메소드 기능을 수행할 수 있도록 함 -> 일일히 코드를 수정하지 않고 xml 설정만 변경해도 됨

- 각 클래스들은 각자의 기능(= 비즈니스 로직)만 집중하면 됨

- 핵심관심 코드와 횡단관심 코드를 분리시키고, 연결고리가 없게 구현 해야 함 -> 나중에 코드를 변경할 때 영향을 주지 않고 편리하게 바꿀 수 있다.

  <br><br>

## AOP Annotation 설정 

- 어노테이션 방식은 주석의 여부로 사전/사후 처리를 정할 수 있다.
- ascpect() 메서드명을 변경했을 때 xml 파일에 등록하거나 수정하지 않아도 된다.
- 어노테이션의 id 가 필요 없다.
  - xml 방식은 Bean 등록 하지 않고 따로 어노테이션 설정 -> 그걸 구분하기 위해 id 가 필요
  - 하지만 애초에 어노테이션으로 설정하면 id가 필요 없어짐

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
                           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">

  <!-- Annotation 기반의 AOP 설정 -->
  <aop:aspectj-autoproxy></aop:aspectj-autoproxy>

</beans>
```

<br>

### 같은 클래스 안에 Pointcut 참조

```java
package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 어노테이션은 이렇게 설정을 해줘야 한다.
@Aspect // Aspect = Pointcut + Advice 
public class LogAdvice {
  @Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
  public void allPointcut() {} 
  // 어떤 기능을 수행할 목적이 아닌 구분을 위해서 식별자형태로 사용하는 것이 참조형 메소드이다.
  // 이것이 필요한 이유는 여러 포인트컷이 실행구문을 넣어 줄 때 그것을 구분하기 위해서 포인트컷을 두개 설정해주고 id로 구분해주듯이 이것을 메소드로 구분해줬다. 

  @Before("allPointcut()") 
  public void printLog(JoinPoint jp) { //JoinPoint 애만 받을 수 있다.
    String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
    Object[] args = jp.getArgs();                // 클라이언트가 전달한 인자 정보 로그인한 회원의 정보들이 담긴다..
    System.out.println("<사전 처리>" + method + "() 메소드 args 정보 : " + args[0].toString());
  }
}
```

<br>

### 외부 Pointcut 참조

- `BoardPointcut.allPointcut()`를 어드바이스 동작 방식 어노테이션에 넣어준다.

```java
package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
  @Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
  public void allPointcut() {} // 어떤 기능을 수행할 목적이 아닌 구분을 위해서 식별자형태로 사용하는 것이 참조형 메소드이다.
  @Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")
  public void getPointcut() {} // 어떤 기능을 수행할 목적이 아닌 구분을 위해서 식별자형태로 사용하는 것이 참조형 메소드이다.
  @Pointcut("execution(* com.rubypaper.biz.user*Impl.*(..))")
  public void userPointcut() {} // 어떤 기능을 수행할 목적이 아닌 구분을 위해서 식별자형태로 사용하는 것이 참조형 메소드이다.
  @Pointcut("execution(* com.rubypaper.biz.board*Impl.*(..))")
  public void boardPointcut() {} // 어떤 기능을 수행할 목적이 아닌 구분을 위해서 식별자형태로 사용하는 것이 참조형 메소드이다.
}
```

```java
package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 어노테이션은 이렇게 설정을 해줘야 한다.
@Aspect // Aspect = Pointcut + Advice 
public class LogAdvice {

  @Before("BoardPointcut.allPointcut()") // 외부 참조 
  public void printLog(JoinPoint jp) { //JoinPoint 애만 받을 수 있다.
    String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
    Object[] args = jp.getArgs();                // 클라이언트가 전달한 인자 정보 로그인한 회원의 정보들이 담긴다..
    System.out.println("<사전 처리>" + method + "() 메소드 args 정보 : " + args[0].toString());
  }
}
```

<br>

### 파라미터 객체

```java
package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around는 사전처리와 사후처리를 모두 할 수 잇다. 서블릿의 filter와 동일한 개념
@Service // 따로 빈 등록 안하고 어노테이션 방법으로 사용함.
@Aspect 
public class AroundAdvice {

  @Around("BoardPointcut.allPointcut()")
  public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {  
    String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름

    Object obj = null;

    StopWatch watch = new StopWatch();
    watch.start();

    obj = jp.proceed();

    watch.stop();

    System.out.println(method + "() 메소드 수행에 소요된 시간 : " + watch.getTotalTimeMillis() + "(ms)초");
    return obj;
  }
  // 리턴타입이 절대 void이면 안된다. 매개변수도 정해져 있다. 비즈니스로직에 대한 사전처리 사후처리이다.
  // 만약 around를 void로 했을 때 사전/사후 처리는 하는데 proceed를 만나서 리턴값이 있는 메소드를 실행시키면 반환 값을 받아서 aroundLog가 받아와도 여기서 return을 해줄 값이 없기 때문에 예외가 발생하고 화면에 출력할 값이 없어진다.   
}
```

<br><br>

## AOP 용어 정리

- 크게 세 가지 존재. 
- 포인트컷 (Pointcut)
- 어드바이스 (Advice)
- 어스펙트 (Aspect) = 포인트컷 + 어드바이스 

### JoinPoint Method

```java
@Before("BoardPointcut.allPointcut()") 
public void printLog(JoinPoint jp) { //JoinPoint 만 받을 수 있다.
  String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
  Object[] args = jp.getArgs();                // 클라이언트가 전달한 인자 정보 로그인한 회원의 정보들이 담긴다..
  System.out.println("<사전 처리>" + method + "() 메소드 args 정보 : " + args[0].toString());
}
```

- 모든 비즈니스 메서드(= 일반 메서드, 포인트컷 후보). 
- JoinPoint 가 있어야 어떤 메서드인지 알 수 있고, 어떤 아규먼트(argument)가 전달되었는 지 알 수 있다.
  - Signature getSignature() : 클라이언트가 호출한 메소드의 시그니처(반환형, 이름, 매개변수) 정보가 저장된 Signature 객체 반환
  - Object getTarget( ) : 클라이언트가 호출한 비즈니스 메소드를 포함하는 비즈니스 객체 반환
  - Object[] getArgs( ) : 클라이언트가 메소드를 호출할 때 넘겨준 인자 목록을 Object 배열로 반환
  - getLongString() : 모든 시그니처 정보를 알려줌.
  - getShortString() : 짧은 시그니처 정보를 알려줌.
  - getName() : 메소드 이름이 뭔지 알려줌.
  - getArgs() : 클라이언트가 메소드를 호출할 때 넘겨준 인자 전체를 배열 형태로 담아서 반환한다.
- ProceedingJoinPoint
  - ProceedingJoinPoint는 JoinPoint 상속했다.
  - ProceedingJoinPoint는 proceed() 메소드 추가되어 있다.
  - Around로 동작하는 어드바이스 메소드는 반드시 ProceedingJoinPoint를 매개 변수로 받아야 한다.
- 클라이언트가 일반 조인포인트에 해당하는 메서드를 호출할 땐 아무런 변화가 없음 
- 횡단관심에 해당하는 공통기능의 메서드(= Advice) 가 동작하려면 PointCut 으로 필터링된 메서드에 대해서만 동작 

#### 중요

- printLog메소드는 누가 호출할까? -> 스프링 컨테이너가 호출
- 이 메소드가 실행되기 전 조인포인트 객체를 생성해서 넣어 주는게 컨테이너가 하는 것
  - 엄청 많은 정보를 담아서 건네준다. setXXX()으로 담아서 넣어주니 getXXX()으로 받아서 사용할 수 있다.

<br>

### PointCut Method

- 필터링 된 조인 포인트. 어떤 패키지, 어느 클래스의 무슨 메서드인지 포인트컷을 이용해 필터링 필요.

  - 필터링 하는 이유 : insert, update와 같이 데이터의 변화가 일어나는 메소드는 실행되다가 예외가 발생하면 롤백(=트랜잭션)이 일어나는데, select 의 경우에는 데이터를 조회하는 것이라 이런 트랜잭션이 필요없음 -> 메소드의 기능에 따라 다르게 처리되어야 해서 필터링이 필요하다.

  ![](https://user-images.githubusercontent.com/46306263/101592041-f1881280-3a30-11eb-89be-8e1646e1dfae.png)

- Pointcut 설정 예시

  ![Pointcut 설정 예시](https://user-images.githubusercontent.com/46306263/101592088-019ff200-3a31-11eb-83f4-1880dd97cb87.png)

  - 리턴타입 : `*`, `void`, `!void` 거의 세 개만 사용. 혹은 디테일하게 객체를 줘서 객체 타입으로 반환하라고 정의 가능 
  - 패키지 경로 :
    1. 끝이 `..` 으로 끝나면 이 패키지로 시작하는 모든 패키지
    2. 정확한 패키지 명을 사용할 수 있다.
    3. `com.rubypaper..user` com.rubypaper로 시작하고, user로 끝나는 패키지
  - 클래스 명 :
    1. `*ServiceImpl`처럼 ServiceImpl로 끝나는 모든 클래스명
    2. `UserServiceImpl`처럼 정확한 클래스명을 줄 수 있다.
    3. `get*` get으로 시작하는 메소드만 사전처리가 동작한다.
  - 매개 변수 :  `..` 은 매개변수의 타입과 개수와 상관없이 모든 걸 의미. 디테일하게 정할 수 있지만 거의 사용하지 않는다.

<br>

### Advice Method

- 횡단 관심에 해당하는 공통 기능의 코드

  ![](https://user-images.githubusercontent.com/46306263/101592402-8723a200-3a31-11eb-8cbb-63597ae5d21c.png)

- 어드바이스 동작 시점을 5가지로 지정

  ![Advice 동작 시점](https://user-images.githubusercontent.com/46306263/101592551-ceaa2e00-3a31-11eb-9527-159d81682da0.png)

<br>

#### After-Returning

- 비즈니스로직을 수행하고 반환된 값을 공통기능로직으로 `returning` 객체에 담아서 넘겨준다.

- 이 반환된 값을 이용해서 사후 처리도 할 수 있다.

  ```xml
  <aop:aspect ref="afterReturning">
    <aop:after-returning pointcut-ref="getPointcut" method="afterLog" returning="returnObj"/>
  </aop:aspect>
  ```

  ```java
  package rubypaper.biz.common;
  
  import org.aspectj.lang.annotation.Aspect;
  import org.aspectj.lang.annotation.Pointcut;
  import org.springframework.stereotype.Service;
  
  @Service
  @Aspect
  public class AfterReturning {
  
    // @Pointcut("execution(* rubypaper.biz..*Impl.get*(..))") // execution()을 ""로 감싼다.
    // public void getPointcut(){}
  
    @org.aspectj.lang.annotation.AfterReturning(pointcut="BoardAdvice.getPointcut()", returning="returnObj")
      public void afterReturningLog(Object returnObj){ 
      // 반환값이 어떤 것으로 올지 몰라서 최상위 객체인 Object로 받는다.
      System.out.println("[사후 처리] afterReturningLog() 실행");
      System.out.println("반환값 : " + returnObj);
      /
    }
  }
  ```

  <br>

#### After-Throwing

- 비즈니스로직을 수행하다가 발생한 예외처리를 공통기능 로직으로 `throwing` 에 담아서 예외를 넘겨준다.

  ```xml
  <aop:aspect ref="afterThrowing">
    <aop:after-throwing pointcut-ref="allPointcut" method="exceptionLog" throwing="exceptionObj"/>
  </aop:aspect>
  <!--
  	- 비즈니스 로직이 serviceImpl 클래스 -> 클라이언트가 메소드를 호출하면 서비스 클래스를 타고 DAO클래스로 가서 거기서 DB연동 작업 -> 반환되서 다시 서비스 클래스로 넘어온 다음 -> 클라이언트 보여지게 되는 것이다.
  	- **중요** : 비즈니스로직 예외가 발생 -> 그 예외를 던져서 어드바이스에서 받아서 처리하는 것!!
  -->
  ```

  ```java
  package rubypaper.biz.board;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Component;
  
  import java.util.List;
  
  @Component("boardService")
  public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDAO boardDAO;
  
    public BoardServiceImpl() {
      System.out.println("===> BoardServiceImpl 객체 생성");
    }
  
    @Override
    public void insertBoard(BoardVO vo) {
      if (vo.getSeq() == 11){
        throw new IllegalArgumentException();
      }
      boardDAO.insertBoard(vo);
    }
  }
  ```

  ```java
  package rubypaper.biz.common;
  
  import org.aspectj.lang.annotation.Aspect;
  import org.aspectj.lang.annotation.Pointcut;
  import org.springframework.stereotype.Service;
  
  import java.sql.SQLException;
  
  @Service
  @Aspect
  public class AfterThrowing {
    //    @Pointcut("execution(* rubypaper.biz..*Impl.*(..))")
    //    public void allPointcut(){}
  
  
    // **중요** : 여기서 비즈니스로직 예외가 발생 -> 그 예외를 던져서 어드바이스에서 받아서 처리하는 것!!
    @org.aspectj.lang.annotation.AfterThrowing(pointcut="BoardAdvice.allPointcut()", throwing="exception")
      public void afterThrowingLog(Exception exception){ // 전달되는 예외가 어느 것인지 모르니 최상위 예외로 받는다.
      System.out.println("[사후 처리] afterThrowingLog() 실행");
      if (exception instanceof IllegalArgumentException){
        System.out.println("IllegalArgumentException 발생");
      } else if (exception instanceof SQLException){
        System.out.println("SQLException 발생");
      } else if (exception instanceof ArithmeticException){
        System.out.println("ArithmeticException 발생");
      } else {
        System.out.println("문제발생!");
      }
    }
  }
  ```

  <br>

#### Around

- 비즈니스로직을 기준으로 사후처리와 사전처리 모두 가능 (= 서블릿의 Filter 와 동일 개념 )

- 주의! Around 에는 roceedingJoinPoint만 파라미터로 사용 가능. `proceed()`를 사용해야 하기 때문.

- 클라이언트에서 요청하면 필터처럼 모든 비즈니스로직이 실행하기 전에 사전처리 시작 -> proceed가 시작되면 비즈니스로직이 수행 -> obj에 반환(obj = jp.proceed()) -> 사후로직 처리 -> obj를 클라이언트로 반환

  - `obj = jp.proceed()` 이게 꼭 실행 되어야 함

  ```xml
  <aop:aspect ref="around">
    <aop:around pointcut-ref="allPointcut" method="aroundLog"></aop:around>
  </aop:aspect>
  ```

  ```java
  package rubypaper.biz.common;
  
  import org.aspectj.lang.ProceedingJoinPoint;
  import org.aspectj.lang.annotation.Around;
  import org.aspectj.lang.annotation.Aspect;
  import org.aspectj.lang.annotation.Pointcut;
  import org.springframework.stereotype.Service;
  
  @Service
  @Aspect
  public class AroundAdvice {
    // @Pointcut("execution(* rubypaper.biz..*Impl.get*(..))") 
    //  - execution()을 ""로 감싼다.
    // public void getPointcut(){}
  
    @Around("BoardAdvice.getPointcut()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable { 
      // proceed 매소드가 Throwable을 던진다.
      Object obj = null;
  
      System.out.println("[사전 처리] aroundLog() 실행");
      long start = System.currentTimeMillis();
      obj = pjp.proceed();
      long stop = System.currentTimeMillis();
      System.out.println("[사후 처리] aroundLog() 실행");
      System.out.println("메소드 동작 시간 : " + (stop-start) + "(ms) 초");
      return obj;
    }
  }
  ```

  <br>

### Weaving

- 위빙. 포인트컷으로 지정한 핵심 관심 메소드가 호출될 때, 어드바이스에 해당하는 횡단 관심 메소드를 결합하는 것

![Weaving](https://user-images.githubusercontent.com/46306263/101594082-6b6dcb00-3a34-11eb-8075-685947deacf6.png)

<br>

### Aspect

- Aspect = Advice
- 포인트컷과 어드바이스의 결합. 애스팩트 설정에 따라 AOP의 동작 방식이 결정된다.
- 어스펙트라고도 하는데 어드바이저라고도 한다.(스프링에서만 유일하게 같이사용)
- 횡단관심과 핵심관심의 결합. 포인트컷과 어드바이스 메서드를 잘 만들어도 어스펙트를 구현하지 않으면 AOP 는 동작하지 않음. (= 의미가 없다)
- 컨테이너에게 모든 비즈니스 메서드가 실행되기 직전 로그 어드바이스 객체가 가지고 있는 printLog() 메서드를 실행하라고 함 -> 포인트컷, 비즈니스 메서드와 어드바이스(횡단관심) 메서드를 적절하게 연결해주는 연결고리가 어스펙트

![image](https://user-images.githubusercontent.com/46306263/101594220-a839c200-3a34-11eb-8025-95bffe7151e5.png)

<br><br>

## XML로 AOP 설정

- Aspect 클래스들을 만들고 메소드를 구현한다.
- xml에서 Aspect 클래스를 빈 등록한다.
- aop 태그를 이용하여 pointcut 설정, aspect advice 동작순서 설정하는 코드를 구현

```xml
<!--  aop 빈을 먼저 등록 -->
<bean id="log" class="com.rubypapper.biz.common.PrintAdvice"></bean>
<bean id="afterReturning" class="com.rubypapper.biz.common.AfterReturning"></bean>

<aop:config>
  <aop:pointcut id="allPointcut" expression="execution(* com.rubypapper.biz..*Impl.*(..))" />
  <aop:pointcut id="getPointcut" expression="execution(* com.rubypapper.biz..*Impl.get*(..))" />
  <aop:aspect ref="log">
    <aop:before pointcut-ref="allPointcut" method="printLog" />
  </aop:aspect> 

  <aop:aspect ref="afterReturning">
    <aop:after-returning pointcut-ref="getPointcut" method="afterReturningLog" returning="returnObj"/>
  </aop:aspect>
</aop:config> 
```

<br><br>

## Annotation AOP 설정

- Aspect 클래스들을 만들고 메소드를 구현한다.
- xml 파일 내  `<context:component-scan base-package="com.rubypapper.biz"></context:component-scan>` 정의
  - 모든 컴포넌트를 스캔한다라는 걸 설정
- `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>`  로 AOP 어노테이션 설정으로 사용 가능.
  -  위 코드를 xml 에 쓰지 않으면 AOP 관련 메서드 동작하지 않음 
- 밑에 처럼 SERVICE, ASPECT, POINTCUT, ADVICE 동작 방식을 설정한다.

```java
package com.rubypapper.biz.common;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PrintAdvice implements Advice {
  @Pointcut("execution(* com.rubypapper.biz..*Impl.*(..))")
  public void allPointcut() {}

  @Before("allPointcut()")
  public void printLog() {
    System.out.println("[사전 처리] printLog() 호출");
  }
}
```

