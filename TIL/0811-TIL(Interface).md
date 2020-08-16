# TIL

# 인터페이스 (Interface)

## 인터페이스란

- 클래스를 사용하는 방식, 접점만을 선언하는 클래스와 유사한 틀
  - public 는 외부에서 접근할 수 있는 메소드처럼 이 클래스가 어떻게 사용되어야 한다는 권고사항이 있을 수 있음 
- 아무런 구현이 되어 있지 않으며, 모든 메소드가 추상 메소드이다.



## 인터페이스의 특징

- class 가 아니고 `interface` 라는 키워드를 사용
- 멤버 변수는 항상 `public static final`
  - 생략 가능함. 외워야 함!!!
- 멤버 메소드는 항상 `public abstract`
  - 역시 생략 가능.
- class 는 하나만 상속 가능하나, interface 는 여러개가 가능하다. (private 는  상속의 의미가 없음)
  - interface 의 상속은 Implements 키워드 사용

```` java
// pulic, default 가능
interface IFoo {
  public static final  int MEMBER_VAR = 10 ; // 상수
  int MEMBER_VAR2 = 20; // public static final 생략

  public abstract void methodA(int param);
  void methodB(int param); // public abstract 생략

}

class Foo implements IFoo {
  @Override
  public void methodA(int param) {
    System.out.println(param);
  }

  @Override
  public void methodB(int param) {
    System.out.println(param);
  }
}
````

>```java
>// interface IFoo <- class Foo
>        // 상속을 받는 자식에서 부모방향으로 화살표를 씀
>        // 묘하기 어려운 inerface는 앞에 I 를 붙이기도 함
>// interface Printable <- class Bar
>```



## 인터페이스간의 상속

- 추상 클래스도 추상 클래스로 상속 할 수 있듯, 인터페이스도 인터페이스로 상속이 가능하다.
  - 인터페이스 간의 'IS-A' 관계
  - 인터페이스가 인터페이스를 상속할 경우 `extends`로 상속
- 클래스 - 클래스 와 달리 다중 상속이 가능하다.

```` java
interface Walkable {
  void walk();
}

interface Runnable {
  void run();
}

interface Jumpable extends Walkable, Runnable{
  void jump();
}

class Jumper implements  Jumpable{
  @Override
  public void walk() {
    System.out.println("walk");
  }

  @Override
  public void run() {
    System.out.println("run");
  }

  @Override
  public void jump() {
    System.out.println("jump");
  }
}
````



## JDK 1.8 이후의 Interface

- 인터페이스에 `default` 메소드를 구현할 수 있다.
-  `default`  메소드는 항상 public 이다.
- 인터페이스의 철학과 맞지 않으나, 인터페이스가 개선되었을 때 모든 자식 메소드에 동일하게 구현되어야 하는 메소드가 생긴 경우 -->  손쉽게 기능 추가를 위해 만들어짐

```` java
interface IFooTwo {
  void abstractMethod();
  
  default void defaultMethod() { //  얜 구현을 해줘야 함 . default method
    System.out.println("Default method---------");
  }
}

class SuperFoo {
  public void defaultMethod() {
    System.out.println("Default method in Super class ");
  }
}

class FooTwo implements IFooTwo {
  @Override
  public void abstractMethod() {
    System.out.println("Abstract method implemented");
  }
}

class FooThree extends SuperFoo implements IFooTwo {
    public void abstractMethod() {
        System.out.println("Abstract method implemented");
    }
}

public class Interface {
    public static void main(String[] args) {
      FooTwo footwo = new FooTwo();
      footwo.abstractMethod();
      footwo.defaultMethod();

      FooThree foothree = new FooThree();
      foothree.abstractMethod();
      foothree.defaultMethod(); // 외워야함. 부모와 인터페이스에 모두 메소드가 있는 경우,
      // 부모 클래스의 있는 메소드를 실행한다.
      // 클래스는 다중 상속이 불가능한데, 인터페이스는 다중 상속이 됨.
      // 겹치는 메소드가 없기 때문에 (추상메소드) 상관이 없는거임. 어차피 override 할거니까.
      // 다중 상속시 문제를 방지하기 위해서 인터페이스보다 일반 상속(다중상속X)가 우선시 됨.

      IBar.staticMethod(); // 인터페이스 명으로 클래스 메소드 호출 가능
      // Bar.staticMethod(); // 구현체인 자식 클래스로는 클래스 메소드 호출 불가능
    }
}
````

