

## TIL(Today I Learned)

#### 자료의 입출력 (Inputs and Outputs)

- 출력 메소드

  - 포맷 문자열을 이용한 문자열/기본형 출력

  ```` java
  System.out.println();		
  // println 의 ln은 line의 약자 
  // System.out.print -> 줄바꿈 되지 않음. 개행문자(\n) 추가 한 게 println
  ````

  ```` java
  public class InputOutput {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
  
      System.out.print("Input integer (1/3): ");
      int valOne = scanner.nextInt();
      System.out.print("Input integer (2/3): ");
      int valTwo = scanner.nextInt();
      System.out.print("Input integer (3/3): ");
      int valThree = scanner.nextInt();
  
      int valMax = valOne > valTwo ? valOne : valTwo;
      valMax = valMax > valThree ? valMax : valThree;
  
      System.out.print("Maximum value:");
      System.out.println(valMax);
      scanner.close();
      // 메모라 낭비를 막기 위해서 다 쓴 건 close
    }
  }
  ````

  

- 포맷문자열 지시자

  ```` java
  System.out.printf("%s is for string \n", "AAAAAAA"); // %s => string
  // result : "AAAAAA is for string"
  
  System.out.printf("%s %s %s", "123", "1423", "1553" );
  // result : "123" "1423" "1553"
  ````

  ```` java
  System.out.printf("%f\n", 14.23); 
  // %f => floating  
  // float -> 자료형. double도 f(loating)로 가능
  
  System.out.printf("%f\n", 14.23f); 
  // result : 
  ````

  | 지시자 | 설명      |
  | ------ | --------- |
  | %e, %E | exponent  |
  | %c     | character |
  | %n     | newline   |

  ```` java
  System.out.printf("%b\n", true); 
  // %b => boolean
  // result : true
  
  System.out.printf("%d 0x%x 0X%X 0%o " ,15, 15, 15, 15); 
  // 10진수 16진수 8진수
  // result : 15 0xf 0XF 017
  ````

  - 진수 표기법

    | 진수법              | 접두어 | 예시     |
    | ------------------- | ------ | -------- |
    | 10진수(decimal)     | -      | `32`     |
    | 2진수(binary)       | 0b     | `0b1011` |
    | 8진수(octal)        | 0      | `0342`   |
    | 16진수(hexadecimal) | 0x     | `0x4A`   |

  

- 정수 포맷팅

  ```` java
  System.out.printf("%5d.\n", 10);  
  // 우측정렬 // 변수사용 불가능
  // res :    10.
  
  System.out.printf("%-5d.\n", 10);  
  // 좌측정렬
  // res : 10   .
  
  System.out.printf("%05d.\n", 234);
  // res : 00234.
  
  System.out.printf("%3d.\n", 104294); 
  // 최소한 3칸을 확보 했으나 출력될 것이 길면 실제 출력될 것이 다 출력됨
  // res : 104294.
  ````

  - 지시자 자릿수 표현

    | 표현  | 설명                                           |
    | ----- | ---------------------------------------------- |
    | %nd   | 최소 n칸을 사용하고 숫자를 오른쪽 정렬         |
    | %-nd  | 최소 n칸을 사용하고 숫자를 왼쪽 정렬           |
    | %0nd  | 최소 n칸을 사용하고 빈칸은 0으로 채움          |
    | %n.mf | 최소 n칸을 사용하고 소수점 이하 m자리까지 표현 |

  

 - 실수 자릿수 표현

   ```` java
   System.out.printf("%5.4f\n", 23545355.54453454); 
   // 소수점 아래로 네자리까지만 표현(뒷자리) + 표현된 뒷자리부터 최소 5칸 확보(소수점포함
   
   System.out.printf("%5.2f.\n", 1.4324); 
   // res : ' '1.43
   
   System.out.printf("%-5.2f.\n", 1.4325); 
   //res : 1.43' '
   ````

   

 - 입력 메소드

   ```java
   Scanner scanner = new Scanner(System.in);
   //상단에 import java.util.Scanner; 생성
   
   scanner.next(); 
   // 공백으로 구분된 String을 입력 받는다
   // next() 메소드는 입력 받는 내용이 있을 때까지 기다린다. => Blocking 메소드 (<-> non-blocking 메소드)
   // 사용 예시 : String val = scanner.next();
   
   scanner.nextInt()
   // 공백으로 구분된 정수를 입력 받는다
   // 자료형이 맞지 않으면 오류
   
   scanner.nextFloat()
   // 공백으로 구분된 실수를 입력 받는다
   // 마찬가지로 입력받은 자료형이 맞지 않으면 오류
     
   scanner.nextLine()
   // new line(Enter)로 구분되는 입력
   // 문자열 전체를 입력 받는다
     
   ```

