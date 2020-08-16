# TIL

## Abstract Stack

- Stack, 후입선출 -> 나중에 넣은 데이터가 먼저 나온다.
- Stack 이란 자료 구조에는
  - is_empty(); 	> 비어 있는지 확인
  - push();            > 데이터를 넣음 
  - pop();              > 데이터를 빼냄
  - peek();            > 데이터를 빼내지 않고 보기만 한다. 확인 후에도 데이터가 존재.



```` java
class ArrayStack extends AbstractStack{  // AbstractStack 를 상속받은 ArrayStack
  private int [] array;

  public ArrayStack(int capacity){
    super(capacity);
    array = new int [capacity];
  }

  @Override
  public void push(int value) {
    if ( top == capacity ) {
      int [] new_array = new int[capacity * 2];
      System.arraycopy(array, 0, new_array, 0, array.length);
      array = new_array;
      capacity *= 2;
    }
    array[top++] = value;
  }

  @Override
  public int pop() {
    if (isEmpty()){
      return -1;
    }
    return array[--top]; // 실제 빼는 것
  }

  @Override
  public int peek() {
    if (isEmpty()){
      return -1;
    }
    return array[top - 1]; // 바로 아래 있는 데이터 출력만
  }
}

````





## 추상 클래스(Abstract Class)란

- 일부 메소드가 구현되지 않고 선언만 되어 있는 클래스
  - 자식 클래스에서 반드시 구현해야 하는 메소드를 `abstract`로 선언
  - 필요한 모든 클래스가 구현될 수 있도록 강제

```` java
abstract class AbstractFoo { // abstract -> 추상클래스 키워드
  int x, y;

  public void method(){
    System.out.println("method");
  }
  
  																		// 세미콜론 잊지말자. 시험에 내기 좋음
  public abstract void abstractMethod(); // 선언만 하고 구현하지 않음! 세미콜론 중요
  																		// 세미콜론 중요!!!!
}

// 객체 생성이 불가능하기 때문에 상속이 필수
class Foo extends AbstractFoo {
  
  @Override
  public void abstractMethod(){
    System.out.println("implemented abstractMethod");
  }
}

public class AbstractClass {
  public static void main(String[] args) {
    // AbstractFoo afoo = new AbstractFoo(); // 추상클래스는 곧바로 객체 생성이 불가능하다
    Foo foo = new Foo();
    foo.abstractMethod();

    //다형성
    AbstractFoo afoo = (AbstractFoo)foo; // 부모 클래스로 자식 클래스를 받는 것
    afoo.abstractMethod(); // virtual method call

    // 추상 클래스는 객체 생성이 불가능하지만,
    // 구현된 자식 클래스의 객체는 받을 수 있다.

  }
}
````



## 추상 클래스의 선언

일부 메소드가 구현되지 않고, 선언만 되어 있는 클래스.  자식 클래스 에서는 이것을 반드시 구현하게끔 강제하는 것.

필요한 모든 클래스가 구현될 수 있도록 하여 인전성을 높인다.

- `abstract` 키워드를 이용해 클래스를 선언
- `abstract` 키워드를 이용해 메소드를 선언

```` java
abstract class AbstractStack { // 추상 클래스
  protected int capacity; // 얼만큼 넣을건지 지정
  protected int top;   // 현재 몇개나 가지고 있는지. 데이터가 들어올때마다 top 이 하나씩 증가함

  public AbstractStack( int capacity) {
    this.capacity = capacity;
    this.top = 0;
  }

  public boolean isEmpty() {
    return this.top == 0;
    //top이 0 이면 true, top 이 증가를 해서 0이 아니면  false
  }

  public abstract void push (int value);
  public abstract int pop();
  public abstract int peek();
}
````



- 클래스 인스턴스 생성 표현식으로 추상 클래스의 인스턴스를 만들려고하면 컴파일 타임 에러가 발생.

```java
  AbstractFoo afoo = new AbstractFoo();  // compile-time error
```

- 추상 클래스를 상속받은 서브 클래스는 인스턴스화 할 수 있다.
  - 물론 이 서브 클래스도 추상 클래스라면 인스턴스화 할 수 없다.
- 추상 클래스가 아닌 클래스가 추상 메소드를 갖는다면 컴파일 타임 에러가 발생한다.