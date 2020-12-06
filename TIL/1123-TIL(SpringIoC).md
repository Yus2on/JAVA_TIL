# Spring IoC



## 프레임워크 (Framework)

- 사전적으로는 `뼈대`, `골격` 을 의미 -> 어플리케이션을 개발할 때 **아키텍쳐(Architecture)에 해당하는 골격을 제공** 
  - 아키텍쳐(Architecture) : 프로그램 주요 구조 설계. 기획한 내용을 프로그램으로 만들었을 때 필요한 주요 특징을 기술적으로 설계하고 명시. 결과물에 필요한 모든 구성요소를 명시하지만 구체적인 구현방법은 포함되지 않음 
- Solution이 완제품이라면 **Framework는 반제품에 해당**
- 이미 완성된 소프트웨어의 개발 인력이 변경될 때마다 설계도를 보고 유지보수 하지만 사실상 일관성을 유지하기 힘듦 -> 일관성이 없어짐 -> 개발자가 달라져도 같은 아키텍쳐를 유지할 수 있도록  뼈대는 프레임워크가 제공 
- 그 위에 비즈니스 로직(Business Logic) 작성

<br><br>

## Framework의 장점 

- 자바 소스 수정없이 유지보수 가능 -> 컴파일을 다시 안 해도 됨 
- 개발자의 역량 획일화 
  - JPA(Java Persistence API) : SQL 을 프레임워크가 생성 
  - 같은 기능을 짧은 코드로 구현할 수 있도록 만들어 주기 때문 
- 빠른 구현 시간 : 복잡한 클래스는 프레임워크가 생성하고 개발자는 비즈니스 로직만 생성
- 관리 용이성 증가
- **검증된 아키텍처의 재사용과 일관성 유지** 
  - 아키텍처는 수많은 레퍼런스를 가진 검증된 회사에서 만들고 개발자가 직접 작성하지 않음 
  - 여러 시스템이 있을 때 각 시스템들이 같은 프레임워크로 되어있다면 아키텍처도 똑같음 (= 시간의 흐름에 따른 아키텍처의 변경이나 깨짐이 없음)

<br><br>

## Java 기반의 Framework

- 자바기반의 프레임워크는 대부분이 오픈 소스 (라이센스가 있지만 사용할 때 별도 비용 지불하지 않음 )
  - 오픈소스를 상속해서 나만의 프레임워크를 쉽게 만들 수 있다는 장점 존재 
- IBATIS / MyBATIS (data Mapper) : 접근하기 쉽고 개발자가 xml 파일에 SQL문 작성. DB 연동 자바 한줄 코드로 가능. 
- JPA / Hibernate (ORM) : 접근 장벽이 높지만  DB 연동 자바 한줄 코드로 가능하며  DBMS의 변경 등을 일일히 수정하지 않고 설정 파일에서 수정 가능 

![](https://user-images.githubusercontent.com/46306263/101141421-a00a0d00-3657-11eb-8280-bc49748bfb87.png)

<br><br>

## Spring Framework

- **경량**
  - 라이브러리 자체의 사이즈가 작아 가벼움
  - **POJO**(Plain Old Java Object) 기반 : 평범한 옛날 자바 객체  < - >  Not POJO : POJO가 아닌 클래스
  - POJO가 아닌 클래스는 클래스를 작성하는데 엄격한 규칙을 적용받는다.  반대로 POJO로 구현된 클래스는 아무런 규칙이 없다 . POJO로 구현된 클래스는 메모리 사용량이 매우 적은 특징을 갖는다. 
- **IoC (Inversion of Control)**
  - 제어의 역행, 역제어. **스프링의 핵심원리**
  - 역제어 <-> 순제어 
  - 순제어는 자바 코드를 작성할 때 직접 new 키워드를 사용해 객체 생성, 관리를 함. (= 제어권을 개발자가 갖고 있다) 이것의 문제점은 객체를 바꾸고 싶을 때 코드를 하나 하나 바꿔줘야 했음 
  - 역제어는 xml파일에 클래스를 작성해 놓으면 컨테이너에서 xml을 로딩 -> 객체 생성, 관리. (= 주체자가 개발자에서 프레임워크로 넘어감) 
  - A 객체를 사용하는 다른 객체들이 많을 때 A 객체를 B 객체로 바꿀 시 xml에 파일의 클래스만 바꿔주면 되기 때문에 유지보수성이 높음 
  - **객체 생성** (= 어플리케이션에 필요한 객체들을 new로 생성해서 사용했었는데 컨테이너가 함 ) 과 **객체 와 객체간의 의존관계** (= 예젠엔 이것도 자바소스로 직접 의존관계를 설정했었는데 컨테이너가  설정에 맞춰서 의존성 주입 해줌 ) 제어를 컨테이너가 가져감 
- **스프링은 컨테이너 (Container) 다.**
  - 컨테이너는 물건을 안전하게 관리하고, 용도에 맞게 물건을 구분해서 관리할 목적으로 사용
  - 서블릿 컨테이너( =서블릿 엔진) 는 Web.xml 에 등록된 클래스를 컨테이너에서 객체를 만들어서 매핑해서 관리
  - 스프링도 컨테이너를 제공
  - Lazy-Loading : 서블릿 컨테이너는 클라이언트가 요청을 할 때 서블릿을 생성 (= 서블릿 엔진이 생성된다고 컨테이너가 생성되지 않음 )
  - Pre-Loading : 스프링 컨테이너는  xml에 작성된 클래스 객체들이 요청을 하지 않아도 컨테이너가 생성되는 순간 같이 생성 
  - 서블릿 컨테이너와 스프링 컨터이너는 디폴트 생성자가 없으면 컨테이너 객체를 생성할 수 없다 
  - 컨테이너는 내부적으로 `Map`이 들어있는 것.  Map 을 내부적으로 운영하면서 xml 에 등록된 객체들을 생성해서 관리한다.

![Spring 컨테이너의 동작](https://user-images.githubusercontent.com/46306263/101280063-3ed66b00-380a-11eb-8580-fb0aad39c93e.png)

<center> <font-weight="bold">applicationContext.xml</font> 에 자바 빈을 등록해준다. <br> applicationContext.xml을 보고 해당 객체를 생성하고, 객체 호출이 오면 해당 객체를 반환해준다.
</center>



<br><br>

## Spring xml file

- 스프링 컨테이너에서 `applicationContext.xml`파일을 로딩 ->  xml파일에 작성하는 것에 따라서 스프링 컨테이너에서 생성하는 객체들이 달라지기 때문에 스프링 컨테이너 제어 가능 

- xml 파일 내 Beans에 `xmlns = "..."`  ->  xml 뒤 ns는 *namespace*의 약자이고, 이 namespace에 등록된 태그만 사용 가능

  ```xml
  xmlns="http://www.springframework.org/schema/beans"
  
  <!-- 이 namespace 에 등록된 태그는 description, import, allias, bean 
  		 - 그 중 bean 을 주로 사용 
  		 - 그 외 context 등 도 사용 가능  
  -->
  ```

  <br>

### Bean

- id 속성과 비슷한 속성으로 `name` 태그를 사용 

- id 태그는 숫자로 시작하거나 공백, 특수 기호 사용 할 수 없다. (= 자바 변수 이름 규칙과 동일 )
- 그에 반해 name  태그는 제약조건이 없어 특수한 아이디를 등록할 때 사용. 일반적으로는 id 태그를 사용한다 
- 스프링 컨테이너의 Bean 등록 된 객체들은 lazy-loading으로 설정 가능 
  - `lazy-init = "true"` 설정으로 lazy-loading 가능 -> 해당 bean 은 클라이언트의 요청이 올 때 메모리에 뜬다.
  - false를 하면 pre-loading 의미 (= 기본값)

- 여러 곳에서 new로 여러 객체들을 생성하면 여러 개가 메모리에 뜨게 되고 주소가 달라지는데 똑같은 객체는 어차피 하나의 기능만 하니깐 여러 개 생성할 필요 없음 ->  **scope 태그로 객체 생성을 관리** 
  - 기본 값이 `singtone` 이라  따로 지정하지 않고 같은 클래스의 객체가 여러개 생성되도 하나의 객체만 생성되어 주소를 알려주는 형태
  - `scope="prototype" `로 지정하면 여러 개의 객체가 생성 되도록 바꿀 수 있다.

- 서블릿 컨테이너로 클라이언트에서 요청 -> 서블릿 하나만 생성 -> 스레드 풀의 스레드들이 이 서블릿을 공유
  - 스프링 컨테이너는 bean 에 클래스가 들어있으면 내부적으로 변환 -> jsp가 서블렛으로 변환되는 것처럼 참조는 하는 객체 생성 -> 이게 싱글톤으로 내부적 구현 되어 있음 

<br><br>

## 클래스를 객체로 사용

### xml 등록

- xml에 `bean` 등록 -> 컨테이너에서 이 bean 을 가지고 와서 객체 주입 
- xml 에 등록된 bean 객체는 순서대로 메모리에 뜨고 bean 등록된 객체들이 생성될 때는  `디폴트 생성자`가 필요
- 등록한 객체 생성할 때 콘솔에서 메모리에 id가 표시되서 출력이 되는데, 따로 id를 지정해주지 않는다면 `패키지.클래스명.#0` 형태로 출력 
  - 사용하기 쉽게 id 를 편리한 이름을 사용해서 지정해서 사용하면 된다.
  - `<bean id="tv" class="polymorphism4.SamsungTv"></bean>`

<br>

### Annotation 사용

- 스프링 IoC 컨셉은 개발자이 유지보수할 때 자바소스가 아니라 xml 설정을 수정  -> 하지만 xml 파일이 길어지면 관리하기 힘듦 -> Annotation(어노테이션) 으로 관리
- Speaker 객체를 자바코드를 변경하지 않고 자유롭게 객체들을 바꾸려면 -> xml로 bean  등록 사용 
  - AppleSpeaker, SonySpeaker의 `@Component` 을 지워야 한다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-3.0.xsd">

	<context:component-scan base-package="polymorphism4"></context:component-scan>
	<!-- 이 패키지로 시작하는 모든 클래스들 중에서 @Component가 붙어있는 클래스를 스캔해라라는 의미 -->	
	<bean class="polymorphism4.AppleSpeaker"></bean>
  
</beans>

```

<center>config-layer.xml</center>

<br>

```java
/************* AppleSpeaker.java ******************/
@Component
public class AppleSpeaker implements Speaker {
  ...
}



/************* LGTv.java ******************/
@Component("Tv")
// 타입을 통해 등록된 Bean객체를 가져올 수 있다
// 또한 IoC컨테이너 객체를 생성할 때 자동으로 객체가 생성되며, Singleton이다.
// 클래스 위에 적으며 개발자가 직접 작성한 class 를 bean 으로 등록하기 위해 사용 
// @Component("bean 이름") 
// 	- 한개의 패키지 내에서 여러개의 이름으로 빈을 등록하는 것이 불가능
// 	- 전체 프로그램에 특정 클래스타입의 bean 을 딱 한번 등록해서 사용할 경우에 사용
public class LGTv implements Tv {

  @Autowired
  // 타입을 통한 자동 주입 -> 변수에 설정해주면 자동으로 타입에 맞는 bean 을 찾아서 setter를 통한 주입 
  //  - LGTv 가 AppleSpeaker 에 의존성을 가지고 있어 Autowired 를 이용하여 의존성 자동 주입 
  // 	- 이 때 AppleSpeaker 도 **Component** 를 가지고 있어야 함 
  private AppleSpeaker speaker; 
  // 이 타입의 객체가 반드시 메모리에 있어야 됨!!

  public LGTv() {
    System.out.println("===> LGTv 생성");
  }

  public LGTv(AppleSpeaker speaker) {
    this.speaker = speaker;
  }
  
  ...
    
}
```

<center>LGTv.java</center>

- `@Service` : ServiceImple 이 붙어져있는 비즈니스 로직을 처리하는 클래스에 사용
- `@Repository` : DAO 처러 DB 와 연동을 처리하는 클래스에 사용 
- `@Controller` : 사용자 요청을 처리하는 클래스에 사용
- 꼭 각 역할을 하는 어노테이션에만 사용해야 하는 건 아님
  -  위 어노테이션들은 @Component를 포함하고 있기 때문에 어디서든 사용해도 상관이 없지만 각 역할 구분을 쉽게 하기 위해 사용하는 것이니 그 역할에 맞게 사용하는 게 베스트 

<br><br>

## DI (Dependency Injection)

- 의존성 주입. IoC 의 핵심으로 `Constructor Injection` /  `Setter Injection`  두 가지가 있음 

- 객체사이의 의존관계를 **스프링 설정 파일에 등록된 정보를 바탕으로 컨테이너가 자동으로 처리**

- 의존성 설정을 바꾸고 싶을 때 프로그램 코드를 수정하지 않고 **스프링 설정 파일 수정**만으로 변경사항을 적용할 수 있음 -> **유지보수 향상**

  - Ex. Tv 클래스 안에  Speaker  기능 생성 ->   Tv에서 소리가 나오게 되어 있으니 Tv가 Speaker를 포함하고 있는 Tv객체와 연관된 Speaker 객체 생성 -> 유지보수하기 좋게 Tv 클래스를 변경하지 않고, 컨테이너에서 객체를 넣어주도록 하는 방법
  - 하나의 스피커를 여러개의 Tv (samsung, lg, google)가 사용 가능. 이 Tv를 여러 클라이언트가 사용할 수 있어서 유연하게 객체들을 수정해주고 주입시켜주기 위해서 유지보수성을 높이기 위해 이런 방법 이용

  - 이렇게 하지 않으면 A 스피커를 사용하다가 B 스피커로 교체할려고 할 때 A 스피커를 사용 중인 Tv 클래스를 전부 변경해야 함 

<br>

### Constructor Injection 

- 생성자 인젝션, 생성자 주입. 
- 스프링 컨테이너는 xml 설정 파일에 등록된 클래스를 찾아서 객체를 생성할 경우 기본적으로 **매개변수가 없는 기본생성자 호출** -> 컨테이너가 기본생성자 말고 매개변수를 가진 다른 생성자를 호출 할 수 있도록 설정 => 생성자 인젝션 사용
  - Ex. Tv 객체를 생성 -> 디폴트 생성자만 호출 (= 매개변수 생성자는 호출되지 못함 )
  - xml 이나 Annotation 설정을 이용해 Tv 가 생성될 때 Speaker 객체도 주입 생성해주는 방법 

```java
// 객체를 만들기 원하는 클래스에 매개변수를 가지는 생성자 만듦 
public SamsungTV(AppleSpeaker speaker) {
  System.out.println("===> SamsungTV 객체 생성");
  this.speaker = speaker;
}

// SamsungTV 객체를 만들 때 그냥 매개 없는 객체를 만들지 않고 AppleSpeaker 매개로 가진 객체를 생성
// 그럼 안에서 따로 AppleSpeaker 객체를 생성하는 코드를 작성하지 않고도 스피커를 통한 메소드를 실행할 수 있다. 
```

<br>

```xml
<!-- bean 설정 --> 
<bean id ="speaker" class="pholymorphism4.AppleSpeaker"></bean>
<bean id="Tv" class="pholymorphism4.SamsungTv">
  <constructor-arg ref="speaker"></constructor-arg>
  <constructor-arg value="150000"></constructor-arg> 
  <!-- 이걸 호출하는 생성자들을 생략하면 실행할 때 오류남 -->
</bean>   
```

> - `constructor-arg` 를 사용해 SamsungTv 가 생성될 때 참조하는 객체를 넘겨준다. ->  AppleSpeaker 생성자가 호출되어 생성 
>
> - 매개변수로 들어갈 객체도 밑에서 <bean\>으로 생성해주어야 먼저 생성된 뒤 그 객체가 매개변수로 들어간다. 
>
>   - 실제 생성 순서는 AppleSpeaker 객체를 먼저 생성하고 SamsungTv 객체를 생성함 
>
> - 매개변수의 수가 많다면 마찬가지로 매개변수가 여러개 있는 생성자를 만들고 `constructor-arg`  를 그 수만큼 넣으면 됨 
>
>   - 생성자가 여러개 오버로딩 되면 어떤 생성자를 호출해야 할 지 불분명 -> `index` 속성 사용 (어떤 값이 몇번 째 매개변수로 매핑되는지 지정 )
>
> - ref : 레퍼런스(*reference*). `id=""` 를 참조. 인자로 전달 된 데이터가 bean 으로 등록된 다른 객체일 경우, ref를 사용해서 해당객체의 id나 name 을 참조. 위 코드에선 스피커 객체의 id를 참조 함.
>
> - value : 고정된 값이나 정수같은 기본형 데이터를 넘길 때 사용한다. 값을 생성해서 넣어준다. ref는 참조할 때 사용함. id 규칙 상 숫자로 시작할 수 없으니 value 를 이용  
>
> - index : 어떤 값이 몇번 째 매개변수로 매핑되는 지정. index는 0 부터 시작한다. 
>
>   - ` <constructor-arg index="0" />`
>
>     

<br>

### Setter Injection

- Setter(세터) 메서드를 호출하여 의존성 주입을 처리하는 방법
- Setter 메서드는 **스프링 컨테이너가 자동 호출 ** -> 호출 지점은 bean 객체 생성 직후 (= Setter Injection 동작을 위해선 Setter method 와 Default method가 필요)
- 스프링 설정파일에 <contructor-arg\> 엘리먼트 대신 **<property\> 엘리먼트 사용**
- 아래 코드에선  SamsungTv  생성할 때 setSpeaker() 메서드를 호출하여서 AppleSpeaker 를 넘겨주라는 의미
- `name` 에서 speaker는 setSpeaker() 메서드 ->  자동으로 set 을 포함
  - `property name="호출하고자 하는 메서드 이름" ref="빈 객체 이름"</property>`
  - setSpeaker() 라고 하면 setsetSpeaker() 를 찾게 되서 오류남. ref는 위의 <bean\>  을 의미한다. 

```xml
<bean id ="speaker" class="pholymorphism4.AppleSpeaker"></bean>
<bean id="Tv" class="pholymorphism4.SamsungTv">
  <property name="speaker" ref="speaker"></property>
  <property name="price" value="15000"></property>
</bean>

```

| 메서드           | 표기               |
| ---------------- | ------------------ |
| setSpeaker()     | name="speaker"     |
| setPrice()       | name="price"       |
| setAddressList() | name="addressList" |
| setBoardDAO()    | name="boardDAO"    |





## 







