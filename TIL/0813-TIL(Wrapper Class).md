# TIL

# Wrapper 클래스 (Wrapper Class)

## Wrapper 클래스란

- 기본형 타입을 객체로 사용하기 위한 클래스
- 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공



## Wrapper 클래스의 종류

| 기본형  | Wrapper 클래스 |
| ------- | -------------- |
| byte    | Byte           |
| char    | Character      |
| short   | Short          |
| int     | Integer        |
| long    | Long           |
| float   | Float          |
| double  | Double         |
| boolean | Boolean        |



## Wrapper 객체 생성

- 생성자를 이용한 객체 생성 -> Integer 이라는 클래스 생성자

  ```java
  Integer integer = new Integer(10);
  Character character = new Character('d');
  ```

- valueOf를 이용한 객체 생성 -> Interger 클래스 valueof 라는  static method 사용 

  ```java
  Integer integer1 = Integer.valueOf(10);
  Character character1 = Character.valueOf('d');
  ```



## Autoboxing & Unboxing

- 오토박싱 (Autoboxing)
  - Java1.5부터 추가된 기능으로, 객체로 다루어야 할 때 자동으로 Wrapper 클래스로 변경하는 기능
- 언박싱 (Unboxing)
  - Wrapper 객체를 기본형으로 자동으로 변경하는 기능

```java
int i = 10;
Integer wrapped = i;
int b = 20 + wrapped;
```

```` java
public class WrapperClass {
  public static Integer add(Integer x, Integer y){
    return x + y; // unboxing -> 자동으로 기본자료형으로 변형되어계산
    // return 될 때는 다시 Autoboxing -> Inteer로 변경
  }
}

public static void main(String[] args) {
  Integer integer2 = 4; // 바로 넣어줄 수 있음
  System.out.println(add(4,2));

  bypass(5); // autoboxing
  // T : Wrapper class 인 Integer로 결정됨
  // 5 -> new Integer(5) (Autoboxing)

  //unboxing
  int m = new Integer(10); // 사칙연산 뿐 아니라 기본 자료형이 필요한 자리에
  // Wrapper class 객체가 있을 경우 자동 unboxing 이뤄짐
}  
````





## Wrapper 타입의 값 비교

- Wrapper 타입은 객체이므로, ==를 이용하여 값을 비교할 수 없다.

  ```java
  Integer intOne = new Integer(100);
  Integer intTwo = new Integer(100);
  
  System.out.println(intOne == intTwo); // false
  System.out.println(intOne.equals(intTwo)) // true
  System.out.println(intOne == 100) // true (Unboxing)
  ```

## 문자열의 기본 자료형 변환

- Parsing 정적 메소드를 이용한 변환

  ```java
  int x = Integer.parseInt("100"); 			// parse+ 자료형 정적 메소드 ---- 권장!!!!
  long y = Long.parseLong("512345124");
  
  ```

- Wrapper 객체로의 변환

  ```java
  Integer intObj = Integer.valueOf("1000");
  Integer intObjTwo = new Integer("1234");
  int y = new Integer("100"); // String을 입력 받아도 파싱 가능
  
  int z = Integer.valueOf("200"); // 얘도 String 가능
  ```