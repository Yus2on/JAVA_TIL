# TIL

## 상속 (Inheritence)



### 상속이란

- 어떤 클래스의 모든 변수 및 메소드를 계승하며, 새로운 클래스를 생성하는 것
  - 부모 클래스로부터 상속받은 자식 클래스는 부모로 부터 상속 받은 것 + 자신의 것으로 이뤄진다
- 상속 대상 : 조상 클래스, 부모 클래스, 상위 클래스, 슈퍼 클래스  => 개념적으로 상위에 있는 클래스
- 상속 결과 : 자속 클래스, 자식 클래스, 하위 클래스, 서브 클래스
- 상속 대상일 필요 조건을 달성하므로 `IS-A 관계`라고도 부른다.

```java
// 부모 클래스
class Person {
  String name; // 인스턴스 변수

  public void work() {
    System.out.println("일하기");
  }

  public void sleep() {
    System.out.println("잠자기");
  }
}




// Person을 상속하는 자식 클래스
// extends 키워드를 이용하여 상속함 => (Developer 클래스는 Person 클래스를 상속한다)
class Developer extends Person{
  String mainLang;

  public void writeCode(){
    System.out.println("돈 받은 만큼 코딩하기");
  }
}


class Student extends Person{
  String major;

  public void writeCode(){
    System.out.println("밤새 코딩하기");
  }
}

public class Main {
  public static void main(String[] args) {
    // 클래스를 상속하면 모든 멤버 변수와 모든 메소드를 상속받는다.
    Developer dev = new Developer(); // Developer 지만 Person이기도 하다.
    dev.name = "나개발";               // Developer 'IS-A' Person
    System.out.println(dev.name);
    dev.work();
    dev.sleep();

    dev.mainLang = "Java";
    dev.writeCode();

    Student stud = new Student(); // Student 'IS-A' Person
    stud.writeCode();
  }
}
```



### 클래스의 포함 관계(Class Composition)

- 클래스를 조립해서 구성한다는 의미
- 상속하고 유사하지만 한 클래스가 다른 클래스의 객체(인스턴스)를 포함하고 있는 관계이다
- 내부에 포함하고 있어서 `HAS-A` 관계로 표현된다
- 객체지향 관점에서 자바에서 지원되는 기능이 부족함 

```java
// MainMachine 'HAS-A' String
class MainMachine {
  String model; //모델
  boolean isBroken = false; // 고장 유무

  public MainMachine(String model){
    this.model = model;
  }
}

// Developer 'HAS-A' MainMachine (Developer가 MainMachine 을 갖고 있다)
// Developer  클래스는 MainMachine의 객체 하나를 보유한다 
class Developer {
  String name;
  MainMachine mainMachine;

  public Developer(String name, MainMachine machine) {
    this.name = name;
    this.mainMachine = machine;
  }

  public void writeCode(){
    if (mainMachine.isBroken){
      System.out.println("코딩을 할 수 없습니다.");
    } else {
      System.out.println(mainMachine.model +" (으)로 코딩하기 ");
    }

    if (Math.random() > 0.9){
      breakMachine();
    }
  }

  public void breakMachine(){
    mainMachine.isBroken = true;
  }
}


// 실행
public class Main {
  public static void main(String[] args) {
    MainMachine mac = new MainMachine("MacBook Pro");
    Developer dev = new Developer("너개발", mac);

    for(int i = 0; i < 10; i++) {
      dev.writeCode();
    } // end for

  }
}
```







## 메소드 재정의 (Method Overriding)

- 메소드의 기능을 재정의한다.
- 다형성 (Polymorphism)의 근간이 된다

```java
class Person {
	public void writeCode() {
		System.out.println("아무 코드나 일단 적어 보았다.");
	}
  
   public void work(){
     System.out.println("열심히 일을 했다");
   }
}	
```

```java
// 'IS-A' 관계
class Develper extends Person{
  @Override // 이렇게 적어 주는 것이 관례. (문법 오류는 아님)
  public void writeCode(){
    System.out.println("개발자 ==========================");
    System.out.println("코드 작성이 하기 싫어서 하지 않았다.");
    System.out.println("==============================");
  }

  public void work(){
    System.out.println("개발자 ==========================");
    System.out.println("일을 하기 싫어서 하지 않았다.");
    System.out.println("==============================");
  }
}


// 실행문
public class Main {
    public static void main(String[] args) {
      Develper dev = new Develper();
      dev.writeCode();
      dev.work();
      
      // 부모 클래스 자료형으로 자식 클래스를 받을 수 있다
      Person p = (Person)dev; // 변수 p는 Develper인 p가 될 수도 있고, 다른 게 될 수도 있다.
      p.writeCode(); // 부모 클래스 자료형이지만 오버라이드 된 메소드가 동작한다.
      p.writeCode();
      // 다형성 (Polymorphism)의 구현 중 하나이다.

      Person [] people = new Person[] {new Develper()};
      //people 은 Person의 array...
      //Person이라는 array에 사람 넣었는데 개발자일 수도 있고, 학생일 수도 있다.
      for(Person person1: people){
        person1.writeCode();
      }

      // p.sleep(); // 부모 클래스로 캐스팅이 되면 자식 클래스에만 있는 메소드는 실행이 안된다
    }
}
```









## super 키워드

- `this`가 현재, 자기 자신의 객체를 참조하듯, `super`는 부모 객체를 참조한다.
- `super.super`로 부모의 부모 객체에는 접근할 수 없다.

```java
class Foo {
  String x = "Foo";

  //생성자
  public Foo(String x) {
    this.x = x;
  }
}

class Bar extends Foo { // Foo 상속
  // 자식클래스 생성자 생성시 부모 클래스의 생성자 호출 필요
  // 부모 클래스에 파라미터 생성자가 있으면 호출 필요
  // 예외적으로 부모클래스의 기본 생성자를 사용할 땐 호출 필요 없음
  public Bar(String x, String x1) {
    //부모의 x도 초기화 해야하고, 자식의 x도 초기화 해야 함.
    super(x); // this 와 마찬가지로 첫줄에 써야함. 부모 클래스 생성자 호출
    // 부모 객체를 먼저 생성성 후 -> 자식 객체 생
    this.x = x1;
  }

  String x = "Bar"; // 멤버 변수명이 부모와 겹치면 재정의

  public void method(){
    // String x = "method"; // 로컬 변수
    System.out.println(x); // 로컬 변수 -> 멤버 변수 -> 부모의 멤버 변수 순으로 접근
    System.out.println(this.x); // this 사용으로 멤버 변수 접근. 멤버 변수 -> 부모의 멤버 변수
    System.out.println(super.x); // super 사용으로 부모 변수 접근.
  }
}

// 아무 것도 상속하지 않은 경우, Object 클래스를 상속하는 것과 같다. 기본적으로 클래스는 object 클래스의 기능을 가지고 있다
// class Jaemi extends Object {
class Jaemi {
  public void method(){ // 인스턴스 메소드 -> 실행 시 객체 call 되는 건 이미 객체가 있어서 가능
  }
}

public class Main {
  public static void main(String[] args) {
    Bar bar = new Bar("","");
    bar.method();
    // 자식 객체를 생성하면, 부모 객체를 먼저 생상하고 그 다음에 자식 객체를 생성함
  }
}
```

> 부모의 생성자를 호출하는 `super` -> 반드시 생성자의 첫줄에만 올 수 있다