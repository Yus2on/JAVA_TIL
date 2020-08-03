# TIL

## 클래스 ( classes )

#### 클래스와 객체

- 클래스 : 객체를 생성하기 위해 사용하는 추상화 된 설계도 (class)
- 객체 :  클래스를 구체화하여 값으로 생성된 것 (object, instance)
  - Instanciation : 클래스를 객체로 만드는 과정

#### 클래스의 구성

- 클래스명은 보통 PascalCase로 적는다
- 속성 : attribute, field -> 클래스에 속하는 멤버 변수, 상태
- 메소드 : Methoed -> 클래스에 속하는 멤버 함수, 행동

```java
public class Car {
    int speed = 0; // 멤버 변수 (속성)
  	// 속성 : attribute, field
  	// 멤버변수 : member variable

    void move() { // 메소드 (method), (가끔 멤버 변수)
        this.speed = 10; // 행위를 구현, 속성을 변경
    }
}
```

#### 객체의 생성

- 클래스를 구체화하여 값을 생성한 것
- 하나의 클래스로 여러개의 객체를 만들 경우, 같은 타입의 독립적인 객체가 된다

```java
Car carOne = new Car(); // new 키워드로 클래스에서 객체 생성
System.out.println(carOne.speed); // .으로 속성 접근 가능
carOne.move(); // 메소드 호출 (method call)
System.out.println(carOne.speed);

Car carTwo = new Car(); // 독립적인 객체가 존재. 객체 여러개 생성 가능
System.out.println(carTwo.speed); 

Car carThree = carOne; // new를 사용하지않음. 참조형 객체이므로 새 객체를 만들지 않았다. carThree 에 carOne을 대입.

System.out.println(carThree.speed); // 10
carThree.speed = 5;
System.out.println(carThree.speed); // 5
System.out.println(carOne.speed); // 5

carOne.speed = 30;
System.out.println(carOne.speed); // 30
System.out.println(carThree.speed); // 30
```

#### 클래스와 객체의 메모리 구조

- 클래스 영역 (Class area, method area, code area, static area)
  - field 정보, method 정보, Type 정보, constant pool
- 스택 영역 (Stack area)
  - method 호출 시 선언된 로컬 변수 (임시로 있다가 사라짐)
- 힙 영역 (Heap area)
  - new 키워드로 생성된 객체
  - garbage collection이 동작하는 영역 (GC). 더이상 사용하지 않는 메모리를 알아서 반환하는 JVM의 기능

```java
public class MemoryStructure { 
  // 클래스 정보는 클래스 영역으로 감. 클래스 영역
  int x, y; // 힙 영역. 객체에 속하는 것은 힙. 클래스가 아니기 때문에 32bit 메모리 (int)를 잡고 있음
  String str = "String"; // 힙 영역, "String"은 상수풀

  public void method (int val) { // 메소드도 클래스 영역에 생성
    // int val => 스택 영역
    char c = 'w'; // 스택 영역

  }
}
```



#### 변수

-----------

- 클래스에 쓰이는 다양한 변수
- 로컬 변수와 멤버 변수

| 구분      | 선언 위치           | 변수 종류          | 특징               |
| --------- | ------------------- | ------------------ | ------------------ |
| 멤버 변수 | 클래스 영역         | 클래스 멤버 변수   | `static` 키워드 o  |
| 멤버 변수 | 클래스 영역         | 인스턴스 멤버 변수 | `static` 키워드 x  |
| 로컬 변수 | 메소드 및 블록 내부 | 로컬 변수          |                    |
| 로컬 변수 | 메소드 내부         | 파라미터 변수      | 메소드의 입력 인자 |

```java
public class Variables {
	static int classVar; // 클래스 멤버 변수
  int instanceVar; // 인스턴스 멤버 변수

	public void method(int parameterVar) { // 파라미터 변수
		int localVar = 0; // 로컬 변수
	}
}
```

#### 인스턴스 멤버 변수 (Instance Variables)

- 인스턴스 변수는 객체를 생성할 때 힙 영역에 생성됨
- 인스턴스 변수는 힙 영역에 생성되므로 초기화가 이루어짐

```java
class VariableTest {
  Variables var = new Variables();
  System.out.println(var.instanceVar); // 0 으로 초기화 됨
  var.instanceVar = 20;
  System.out.println(var.instanceVar);

  Variables var2 = new Variables();
  System.out.println(var2.instanceVar);
  System.out.println("");

  System.out.println("인스턴스 멤버 변수");
  Variables var = new Variables();
  System.out.println(var.instanceVar); // 0으로 초기화
  var.instanceVar = 20;
  System.out.println(var.instanceVar);

  Variables var2 = new Variables();
  System.out.println(var2.instanceVar);

  // System.out.println(var2.classVar); // 가능하나 권장하지 않음
  // Variables.instanceVar 접근 불가능å
} 
```

#### 클래스 멤버 변수 (Class Variables)

- 클래스 멤버 변수는 프로그램 시작 시 클래스 영역에 생성됨
- 객체가 아닌 클래스로 접근하는 것이 권장됨 (객체로 접근도 가능하나 비권장)

```java
class VariableTest {
	System.out.println(Variables.classVar); // 0 으로 초기화 됨
	//클래스 변수는 클래스  이름으로 바로 접근 가능
	Variables.classVar = 10; // 클래스이름.변수명으로 접근
	// 접근 -> 수정도 가능
	System.out.println(Variables.classVar);
	System.out.println("");
}
```

#### 로컬 변수 (Local Variable)

- 메소드 또는 중괄호 블록 내부에서 생성되는 볍ㄴ수
- 스택 영역에 생성되며, 초기화가 이루어지지 않음
- 생명 주기 (Life cycle)은 생성된 중괄호 블록이 종료될 때 까지

```` java
public class Variables {
  public void method(int paramVar){ //로컬 파라미터 변수
    int localVal; // 로컬 변수
    localVal = 10;

    //System.out.println(localVal); // 로컬변수는 0으로 초기화 할 수 없음
    localVal = 10;
    System.out.println(localVal); // 값 대입 후 사용

    {
      localVal = 30;
      int localVal2 = 20;
    }
    // localVar2 = 40; // => 접근 불가. 생명주기가 끝났다 (Life-cycle)
  }
}

class VariableTest {
  var.method(9);
}
````



