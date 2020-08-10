# TIL



## 다형성 (Polymorphism)

### 다형성의 다양한 특징

- 부모 클래스 타입으로 자식 클래스 객체를 참조하는 특징을 갖는다

  ```` java
  class Foo {
    public void methodA() {
      System.out.println("A");
    }
  }
  
  class Bar extends Foo {
    public void methodB() {
      System.out.println("B");
    }
  }
  
  public class Poly01 {
    public static void main(String[] args) {
      Bar bar = new Bar(); // new => 새로운 객체 !!! 자식 객체를 새로 생성
      Foo foo = (Foo)bar; // 부모 클래스 타입으로 자식 객체를 받음 foo로 casting
      // 여전히 힙 영역에는 자식 객체가 존재
  
      foo.methodA();
      //foo.methodB();    // 이 경우 문법적으로 자식 클래스 메소드는 사용 불가능
  
      Foo foo1 = new Foo(); // Foo클래스 객체 생성
      // Bar bar1 = (Bar)foo1; // 자식 클래스 타입으로 부모 객체를 받음 -> 문법오류는 아니지만 런타임 오류 발셍. 애초에 자식 클래스 타입으로 부모 객체를 받기가 불가능. 성립할 수 없음
      // 자식 클래스 자료형으로 객체를 보려 하지만, 부모 객체 부분만 있기 때문에 런타임 오류 발생
      // bar1.methodB();  // 문법 오류 x. methodB는 Bar라는 클래스에서 만든 거라서 쓸 수 있지만 자식 클래스 타입으로 부모객체를 받은 게 오류
      // bar1.methodA();  // 문법 오류 x -> 마찬가지로 성립할 수 없음 함
      // Bar > Foo : Bar에 Foo 가 속해있는 상황
  
      // 문법오류는 빌드 자체가 불가능, 런타임 오류는 실행은 되나 실행 중간에 발생하는 오류를 런타임 오류라고
  
      // 자식 클래스 타입으로 자식 객체를 받음
      // 힙 영역에는 계속 자식 객체가 있었던 것
      Bar bar1 = (Bar)foo; // foo = 자식 객체를 담고 있는데 다시 자식 객체로 casting
      //bar1.methodA();
      //bar1.methodB();
    }
  }
  ````

  - 부모 클래스로 자식 클래스를 참조한 경우, 자식 클래스의 메소드는 사용할 수 없다.

  ```java
  public class Main {
    public static void main(String args[]) {
      Bar bar = new Bar();
      Foo foo = (Foo)bar;
  
      foo.methodA();
      // foo.methodB(); // error
    }
  }
  ```

  - 자식 클래스로 부모 클래스를 참조하려 하면 java.lan.ClassCastException 오류 발생

  ````java
  public class Main {
    public static void main(String args[]) {
      Foo foo = new Foo();
      Bar bar;
  
      // bar = (Bar)foo; // error
      if (foo instanceof Bar) { // returns false
        bar = (Bar)foo;
      }
    }
  }
  ````



- 멤버 변수의 재정의는 선언된 객체 타입을 따른다 (문법적으로 본다)
- 메소드 오버라이드는 메모리 상의 객체 타입을 따른다 (실제 객체로 본다)
  - 가상 메소드 호출 : Virtual method call

``` java

class Foo {
  static public String y = "Super class";
  public String x = "Super";

  public void methodA(){
    // 들러리 역할 -> Virtual method (실제로 호출되지 않고 문법적으로 얘가 호출되는 것처럼 보임
    System.out.println("Super Method");
  }
}

class Bar extends Foo {
  public String x = "sub";

  @Override
  public void methodA() {
    System.out.println("Sub Method");
  }
}

public class poly02 {
  public static void main(String[] args) {
    Bar bar = new Bar();
    Foo foo = (Foo)bar; // Bar 객체를 다시 foo 로 받음

    System.out.println(bar.x); // 자식 객체인 sub
    bar.methodA(); // Sub Method

    System.out.println(foo.x); // Super
    foo.methodA(); // Sub Method // Virtual method call

    // foo, bar 는 자식 객체 -> static 이 있던 없던 간에 부모 쪽 변수
    // bar 는 자식 쪽 변수 
  }
}

```





### 공변 반환 타입 (Covariant return type)

```java
class Foo {
  public Foo getInstance() { // 메소드
    return this;
  }
}

class Bar extends Foo {
  // 상속을 해서 오버라이딩을 하려면 Foo, Bar에 있는 리턴 타입이 똑같아야 하지만
  // Covariant return type은 예외적으로 리턴 타입으로 Bar를 사용
  // 오버로딩이 아님.....
  // 자식 쪽에서만 가능. 상속 받았기 때문에
  @Override
  public Bar getInstance(){ // Foo 대신 Bar  로 리턴 가능
    // public Foo getInstance(){
    return this;
  }
}

public class Poly03 {
  public static void main(String[] args) {
    Bar bar = new Bar();
    bar.getInstance();
  }
}
```