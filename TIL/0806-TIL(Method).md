# TIL

## 메소드 (Method)

### 메소드란

- 객체가 하는 동작(행위)을 정의하는 작업을 수행하는 코드의 집합, 나열

- 코드의 중복을 방지, 유지보수성을 향상, 코드의 가독성 개선

  ```` java
  class Bar { 
    // 인스턴스 메소드. 보통 그냥 메소드라고 한다.
    // Return type ( 출력의 자료형 )
    
    // int add를 반환하는 메소드 선언.
    // 선언 (Declaration) - ~ 한 것이 있다. 실제 구현은 x
    // 정의 (Definition) - 메소드 내용까지 있어야지 정의. 선언 + 구현 (초기화)
    public int add (int x, int y) { 
      // x, y -> 입력 파라미터. 메소드 호출 할 때 같이 입력. 
      return x + y; // return value (반환값)
    }
    
    // 정벅 메소드(Static method) == 클래스 메소드
    // void return type 는 return 이 없다
    public static void classMethod() {
      System.out.println("클래스메소드 호출");
    }
    
    //실행부
  	public class Methods {
      // main 메소드에서 java프로그램이 실행이 되는 것은 약속. 
      // main메서드도 static 메서드(인스턴스 호출없이도 실행은 되어야 되기 때문에)
      
      public static void main(String[] args) {
        // 클래스 메소드 호출. 클래스 메소드는 바로 콜이 됨
        Bar.classMethod();
        
        // Bar.add(1, 2); -> 호출 할 수 없음
        Bar bar = new Bar(); // 인스턴스 하나 생성 후 호출 가능
        System.out.println(bar.add(1,2)); // 메소드 호출. return 값으로 대치됨
        // bar.add(1,2)가 반환값으로 대치가됨
        
        // bar.classMethod();
        // 인스턴스에서 클래스 메소드를 호출할 수 있지만 권장하지 않음
      }
    
    }
  
    
  } 
  
  ````

  > - method는 Return type, 실행문, 입력 파라미터, Return 으로 구성.
  > - 변수에서 처럼 인스턴스 메서드와 클래스 메서드로 구분한다.
  > - **클래스 메서드는**  **static 키워드를 가지는 메서드**로, **인스턴스 없이 클래스명으로 호출**할 수 있다. 클래스에 속함.
  > - **인스턴스 메소드**는 **인스턴스 생성 후 호출**할 수 있다.
  > - 선언은 ~한 것이 있다고 얘기하는 것이고 정의는 선언+구현(초기화)한 것을 말함
  > - 클래스 변수는 클래스 생성(import하는 순간 클래스생성)과 동시에 초기화되고 인스턴스 변수는 인스턴스생성시 초기화됨
  > - 메서드는 실행문 작성시 초기화되고 실행문은 빈{]도 포함됨/ 선언부만 있는것이 선언한 상태(추상메서드)



### 클래스와 메서드 

```java
//실행부
Person p1 = new Person(); // p1 변수명 자료형 Person// Person이라는 인스턴스가 할당되어있음
Person p2 = new Person();
// 인스터느 메소드는 객체의 속성을 변화시키는 역할을 한다.

p1.eat(); //메서드 콜
System.out.println(p1.isHungry);//false
System.out.println(p2.isHungry);//true  // p1의 eat이 p2에까지 영향을 미치지 않는다.

Person.describe();//사람입니다. // 특정한 객체의 속성을 바꾸는 역할을 하지 않는다. 
// static 변수를 변화 시킬수는 있다.
```

- 클래스 메서드는 클래스 변수의 속성을 변화시킬 수 있지만 인스턴스 변수를 변화시키지 않는다
- 인스턴스 메서드는 객체의 속성을 변화시키는데 사용된다.



### 기본형 변수, 참조형 변수

- 기본형 변수 : 메소드 인자로 값이 전달된다 (Call by value)
- 참조형 변수 : 메소드 인자로 참조가 전달된다 (Call by reference)

```java
class Foo{
  int value;
}

class Bar{
  //기본형 변수를 파라미터로 사용한 메서드
  public static void swapPrimitive(int x, int y){ // bar에 속성과는 상관없어서 static으로만듬
    int temp = x;
    x = y;
    y = temp;
  }
  
  // int x, int y의 사본이 넘어온다.
  // 기본형 타입(Primitive type)인 경우에 해당
  // call by value : 메소드 호출을 할 때, 값을 복사해서 넘긴다.
  // 값을 복사해온 이후에는 외부의 x,y변수와는 상관없는 애가됨. 그래서 밖에 변수가 안변함

  // 참조형 변수를 파라미터로 사용한 메서드
  public static void swapReference(Foo x, Foo y){
    // Foo -> class, class는 참조형 변수// 사본이 아닌 해당 변수를 가르킴
    int temp = x.value;
    x.value = y.value;
    y.value = temp;
  }

  //실행부
  // Call by
  int x = 10;
  int y = 20;

  Bar.swapPrimitive(x, y);
  System.out.println(x+","+y); //10,20 // 변화없음 왜? 위에 메서드에 설명

  Foo f1 = new Foo();
  Foo f2 = new Foo();

  f1.value = 10;
  f2.value = 20;
  Bar.swapReference(f1, f2);
  System.out.println(f1.value + "," +f2.value);//20, 10 => 값의 변화에 영향을줌
}  
  
```

> 기본형 변수를 파라미터로 사용할 경우 외부변수의 사본을 가져와서 실행문에 입력 => 메서드의 결과 값이 외부 변수에 영향을 X => 실행문에 출력값에 변화를 주지 못함
>
> 참조형 변수를 파라미터로 사용할 경우 해당 변수를 참조 하기 때문에 메서드의 결과값이 해당 변수에 영향을 줌 => 실행문에 출력값에가변 인자(Variable Arguments) + 메서드 오버로딩



```` java
                        // 여러개의 int를 입력 받는다.
                        // 입력 받은 결과는 배열로 주어진다.(params는 배열명, 바뀔수 있음)
                        // 가변 인자(Variable arguments) 인자가 변한다.
public static int sumAll(int... params){
  int sum = 0;
  for (int val : params){
    sum+= val;
  }
  
  return sum;
}

// 메소드 오버로딩 Overloading
// 함수명은 같고 입력인자가 다른 메서드
// 입력 인자의 갯수도 다를 수 있다.
public static float sumAll(float... params){
  float sum = 0;
  for (float val : params){
    sum+= val;
  }
  return sum;

  //실행부
  System.out.println(Bar.sumAll(2,3,4,1,3,24,346,1,2,34,-123,-12,2));// 287
  System.out.println(Bar.sumAll(2.2f,0.2f,3.2f,56.23f));// 61.83 // int, float 동시 
  // println이 자료형에 상관없이 동장하는 이유 = 오버로딩
}  
````

> - 같은 data type에 여러개의 파라미터를 입력할 때 가변 인자를 사용함
> - 자료형... params을 사용
> - 입력 받은 결과는 배열로 주어짐 // dataType[] params; // params는 배열명 - 바뀔 수 있음
> - 같은 함수명을 갖고 입력인자가 달라서 여러가지 data type을 입력 받을 수 있게 하는 것을 메서드를 오버로딩이라고함
> - 입력 인자의 갯수도 다를 수 있고 대표적인 예로 prinln()이 있음





#### 클래스 안에 main메서드가 포함된 경우

```` java
public class Method {
  public static void classMethod() {
    System.out.println("클래스 메소드 호출");
  }

  public void instanceMethod() {
    System.out.println("인스턴스 메소드 호출");
  }

  // main 메소드에서 실행이 되는 것은 약속. main메서드도 static 메서드
  public static void main(String[] args) {

    //main 메서드에서는 어떻게 클래스 /인스턴스 메서드를 호출 하나 - 퀴즈

    classMethod();// 동일 클래스에 속한 클레스 메소드 호출(클래스 명 필요 X)
    // 클래스메서드에서는 같은 클래스에 다른 클래스메서드를 바로 호출이 가능함
    Method.classMethod();// 생략 안할수도 있음
    Method m = new Method(); // 인스턴스 생성 안되어있으니 생성해야함.
    m.instanceMethod(); // 인스턴스 메소드 호출
  }
}  
````

> - main 메서드는 프로그램의 시작부라고 약속된 클래스 메서드로 실행기능을 담당
> - 하나의 클래스에서 선언된 클래스 매서드는 클래스명 없이 호출 가능
> - 인스턴스 메서드는 같은 클래스 안에서라도 인스턴스를 생성해야 호출 가능함