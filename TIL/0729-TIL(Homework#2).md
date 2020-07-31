## Homework #2

	#### 	Input, Output

```` javascript
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자 1 : ");
        int num1 = scanner.nextInt();

        System.out.print("숫자 2 : ");
        int num2 = scanner.nextInt();

        System.out.print("숫자 3 : ");
        int num3 = scanner.nextInt();

        int maxNum = (num1 > num2 ? num1 : num2 ) > num3 ? (num1 > num2 ? num1 : num2 ) : num3;

        System.out.print("최대값  : " + maxNum);
    }
}		
````

- <em>maxNum</em> 출력 하기 전에 같은 값을 입력했는지 체크하는 로직이 있으면 좋을 것 같다.

  - ```` java
    if((num1 == num2) || (num1 == num3 ) || (num2 == num3)){
    	System.out.println("같은 숫자 존재");
    }
    ````

    - 더 간단한 방법은 없을까?



#### PrintFormat

```` java
int id = scanner.nextInt();
if(!(id > 0 && id <= 999999)){
	System.out.println( "0부터 999999 이하의 정수를 입력하세요");
  return;
 }
````

 - <strong>!(조건)</strong> 은 부정. 

    - ```` java
      int a = 10;
      int b = 20;
      if(!(a == b)){
        // a와	b가 같지 않을 때 실행되는 조건
        // if(a != b){}
      }
      ````



#### RingCounter

```` java
Integer.parseInt(variable, 2)
// variable -> 변수
// 2 진수를 10진수로 변경하겠음. 만약 8이면 8진수를 10진수로
  
Integer.toBinaryString(variable)
// variable -> 변수 혹은 숫자
// toBinaryString -> 10진수를 2진수로 변환
````

