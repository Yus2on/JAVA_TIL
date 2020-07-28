# TIL(Today I Learned)

#### 연산의 구성

- 연산자 (Operator), 피연산자 (Operand), 연산식 (Expression)

  

#### 우선순위 표

 - 우선순위가 같은 경우 결합 방향 순으로 진행

   | 연산자                               | 결합 방향 | 우선순위 |
   | ------------------------------------ | --------- | -------- |
   | ()                                   | →         | 1        |
   | ++ -- + - ~ ! (int)                  | ←         | 2        |
   | * / %                                | →         | 3        |
   | + -                                  | →         | 4        |
   | << >> >>>                            | →         | 5        |
   | > < >= <= instanceof                 | →         | 6        |
   | == !=                                | →         | 7        |
   | &                                    | →         | 8        |
   | ^                                    | →         | 9        |
   | \|                                   | →         | 10       |
   | &&                                   | →         | 11       |
   | \|\|                                 | →         | 12       |
   | ?:                                   | →         | 13       |
   | = += -= *= /= %= ^= \|= <<= >>= >>>= | ←         | 14       |

#### 연산자의 종류

- 산술 연산자, 대입 연산자, 비교 연산자, 논리 연산자, 증감 연산자, 삼항 연산자, 비트 연산자

  

  - #### 산술 연산자

    - | 연산자 | 기능                               |
      | ------ | ---------------------------------- |
      | +      | 두 피연산자의 합                   |
      | -      | 두 피연산자의 차                   |
      | *      | 두 피연산자의 곱                   |
      | /      | 두 피연산자의 나눈 몫              |
      | %      | 두 피연산자의 나눈 나머지(Modulus) |

      ```java
      int x = 10, y= 20, z;
      z = x + y; 
      // + : 피연산자 x,y : 연산자 x+y : 연산식(Expression)
      // 대입도 연산자.  =: 연산자, z: 피연산자, x+y: 피연산자
      // 대입 연산자의 우선 순위가 가장 낮기 때문에 가장 마지막에 실행
      ```

      ```java
      /***정수형 사칙 연산***/
      System.out.println(16 / 8); 
      // 정수 나누기 -> 몫(소수점 버림)
      // res : 2
      
      System.out.println(17 % 8); 
      // modulus 연산, 나머지
      // res : 1
      
      
      /***실수형 사칙 연산***/
      System.out.println(10.0 - 52.3); 
      // res : -42.3
      
      System.out.println(10.5f - 12.3);
      // float, double 이 같이 연산되면 double로 변한 후 연산
      // res : -1.8000000000000007
      
      System.out.println(10.4 - 50);
      // 실수형, 정수형 같이 연산하면 실수형으로 변환 후 연산
      // res : -39.6
      
      System.out.println(150 / 8.0);
      // 실수로 나누면 소수점까지 계산
      // res : 18.75
      
      System.out.println(5.2 / 1.2);
      // 몫이 아니고 실수 값으로 계산 됨
      // res : 4.333333333333334
      
      System.out.println(5.2 % 1.2);
      // 실수 나눗셈도 modulus 연산으로 나머지 계산 가능
      // 부동수소점->오차생김
      // res : 0.40000000000000036
      ```

      - 사칙연산의 중요성

      ```java
      System.out.println(Integer.MAX_VALUE / 2 * 3 ); 
      // res : -1073741827  -> 값이 넘쳐서 overflow됨
      
      System.out.println(Integer.MAX_VALUE); 
      // res : 2147483647 -> 가장 큰 값
      
      System.out.println(Integer.MAX_VALUE+1 ); 
      // res : -2147483648 -> +1이 되니까 가장 작은 값이 됨
      // overflow
      // MIN_VALUE 일때도 동일
      
      // -------------------------------- 주의할 점 -------------------------------- // 
      /*
      * 정수형 : 오버플로우
      * 정수를 0으로 나누면 by zero
      * 맨 앞자리가 0 -> 양수, 1 -> 음수
      * 음수를 표현하기 위한 방법
      * 0과 1을 뒤집은 다음에 + 1 => 1's complement
      */
      
      /*
      * System.out.println( (6 - 5.9) * 10 ); // 정밀도 떨어져서 0.999999999.....
      * System.out.println(Math.floor((6 - 5.9) * 10)); // 0.0 // 정밀도 문제로 1이 나오지 않음
      * 수식은 문제가 없지만 값에서 문제가 생길 경우 존재
      	System.out.println( 40 / 0.0 ); //Infinity // 매우 큰 숫자
      	System.out.println( 40 % 0.0); // NaN == Not a Number (숫자가 아니다, 계산 불가능)
      */
      
       
      ```

- #### 대입 연산자

  ```java
  z += 10; // z = z + 10; 을 줄인 형태
  z %= 10; // modulus, 비트, 논리 연산자 가능
  ```

  | 연산자 | 기능                                                         |
  | ------ | ------------------------------------------------------------ |
  | =      | 우측 피연산자의 값을 좌측 피연산자 변수에 할당               |
  | +=     | 두 피연산자의 합을 좌측 피연산자에 할당                      |
  | -=     | 두 피연산자의 차를 좌측 피연산자에 할당                      |
  | *=     | 두 피연산자의 곱을 좌측 피연산자에 할당                      |
  | /=     | 좌측 피연산자를 우측 피연산자로 나눈 몫을 좌측 피연산자에 할당 |
  | %=     | 좌측 피연산자를 우측 피연산자로 나눈 나머지를 좌측 피연산자에 할당 |



* #### 비교 연산자
  * boolean으로 출력 (true` 또는 `false`)

    ```java
    System.out.println(10 > 20); // 거짓 : false
    System.out.println( 10 < 20); // 참 : true
    System.out.println( 10 >= 10); // true;
    
    int x= 10; y=10;
    System.out.println(x == y); // true
    System.out.println(x != y); // false
    ```

    | 연산자 | 기능                                             |
    | ------ | ------------------------------------------------ |
    | <      | 좌측 피연산자가 우측 피연산자보다 작은가?        |
    | >      | 좌측 피연산자가 우측 피연산자보다 큰가?          |
    | <=     | 좌측 피연산자가 우측 피연산자보다 작거나 같은가? |
    | >=     | 좌측 피연산자가 우측 피연산자보다 크거나 같은가? |
    | ==     | 좌측 피연산자와 우측 피연산자가 같은가?          |
    | !=     | 좌측 피연산자와 우측 피연산자가 다른가?          |



- #### 논리 연산자

  - 입출력 모두 boolean

  ```java
  // a AND b : a, b 모두 참일 때만 참
  // a OR b : a 또는 b 둘 중 하나만 참이어도 참
  // a XOR b : a 또는 b 둘 중 하나만 참이어야 참 //exclusive or, 배타적 or
  // NOT a : a 가 참이면 거짓, 거짓이면 참
  
  System.out.println(10 < 20 & 40 >= 2); //true
  System.out.println(40 < 2 | 1 > 0); //1 거짓, 2 참 -> true
  System.out.println(!true);  //false
  System.out.println(!false); //true
  System.out.println(!(10 > 20)); // 10이 20보다 크지 않아서 false 인데 not 이라서 true
  System.out.println(10 > 2 ^ 5 > 2); // ^ : XOR //둘다 true 라서 false
  
  //////////////
  // short-circuit : && , || (NOT, XOR은 두번 쓰기 불가능)
  // 두번 쓰는 게 속도가 더 빠름
  //////////////
  ```

  | 연산자 | 기능 |
  | ------ | ---- |
  | &      | AND  |
  | \|     | OR   |
  | !      | NOT  |
  | ^      | XOR  |



- #### 증감 연산자

  - 단항 연산자

  ```java
  int val = 0;
  System.out.println(val++); 
  // val = 0 으로 먼저 Expression 평가 후 val += 1;
  // sout(val);
  // val += 1;
  
  System.out.println(val); 
  // val == 1;
  
  System.out.println(++val); 
  // val +=1 을 먼저 계산 후 Expression 평가
  // val += 1;
  // sout(val)
  
  System.out.println(val--);
  // sout(val);
  // val -= 1;
  
  System.out.println(val); 
  // val == -1;
  
  System.out.println(--val);
  // val -= 1;
  // sout(val)
  
  
  val = 5;
  int new_val = val++ * 10 + --val;
  // 1. 5 * 10 = 50 -> val = 6인 상태로 10 + --된 val(5) = 55
  
  ```

  | 연산자       | 기능                                        |
  | ------------ | ------------------------------------------- |
  | ++ (Prefix)  | 피연산자의 값을 1 증가한 후 연산식 평가     |
  | ++ (Postfix) | 연산식을 평가한 후에 피연산자의 값을 1 증가 |
  | -- (Prefix)  | 피연산자의 값을 1 감소시킨 후 연산식 평가   |
  | -- (Postfix) | 연산식을 평가한 후에 피연산자의 값을 1 감소 |



- #### 삼항 연산자

  - ```java
    (cond)  ?  (true expression):(false expression)
    // boolean ? 값 : 값
    ```



- #### 비트 연산자

  - 정수형 연산에 사용

  | 연산자 | 기능                        |
  | ------ | --------------------------- |
  | &      | AND : enfe                  |
  | \|     | Bitwise OR                  |
  | ~      | Bitwise INV (비트 부정)     |
  | ^      | Bitwise XOR (배타적 논리합) |

  - 비트 부정(~) 연산자. 0000을 비트 부정하면 1111 -> 반전된 값 '1의 보수'

  - 시프트 연산자

    | 연산자 | 기능                     |
    | ------ | ------------------------ |
    | <<     | Bitwise 왼쪽으로 shift   |
    | >>     | Bitwise 오른쪽으로 shift |

    - 양수는 0, 음수는 1이 채워짐

