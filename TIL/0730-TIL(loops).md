## TIL

- 반복문 (Loops)

- for 문, while 문

- 초기화 - 반복문을 실행하기 위해서 증감할 변수를 초기화

- 조건식 - 반복문을 실행할 조건(또는 종료 조건)

- 실행문 - 조건식이 참 (또는 거짓)일 경우에 실행할 코드

- 증감식 - 무한루프가 되지 않기 위해 실행문이 실행된 후 변수에 증감

  

- **for 문** 

  ```` java
  //for 문
  //초기화      ; 조건식 ; 증감식
  for(int i = 0; i < 5; i ++){
    //초기화는 한 번 하고 끝
    	System.out.println(i); // 실행문
  }
  ````

  ```` java
  for(int i = 0; i<5; i += 2){
    //증감식에 수식이 들어갈 수도 있음
    System.out.println(i);
  }
  ````

  ``` java
  for(int i = 4; i>=0; i--){
    // 4 - 0까지 출력
    System.out.println(i);
  }
  ```

  ``` java
  // nested for
  // i가 0인 상태로 for 실행   i가 0일 때 j는 0 - 4
  for(int i = 0; i < 5; i++){
    for(int j = 0; j < 5; j++) {
      System.out.printf("(%d, %d)\n", i, j);
    }
  }
  // 5 * 5 = 25
  ```

  ```` JAVA
  for(int i = 0; i < 5; i++){
    System.out.println(i);
    System.out.println(""); // not iterated : 반복이 되지 않았다
  }
  ````



 - **while 문**

 - 초기화 

 - while(조건문) {}

 - 실행문

 - 증감식

 - }

   ```` java
   int i = 0;
   while(i < 5){
     System.out.println(i);
     i++;
   }
   ````

   - for문과 차이 : while은 변수를 반복문 바깥에서 정의 - > 한번 사용하면 재정의 필요
   - do-while 도 초기화를 밖에서 해줌

   ```` java
   i = 0;
   do{
     System.out.println(i);
     i++;
   }while(false);
   // while이 flase 여도 do는 반드시 한 번 실행이 됨
   ````

   

   - 제어문 - break / continue

   ```java
   for(i=0; i<10; i++){
   	if(i == 3){
   		// 0, 1, 2 는 그냥 실행 -> 3실행하면서 조건문 실행
   		// -> 실행을 중단하고 i가 4가 됨 -> 그 이후는 0, 1, 2... 처럼 진행
   		continue;
   	}
   System.out.println(i);
   }
   ```

   ```java
   for(i=0; i<10; i++){
   	if(i == 3){
   		//바로 반복문 종료함
   		break;
   	}
   System.out.println(i);
   }
   ```

   ```java
   loop1: //레이블 : 명칭 자유. 중첩 반복에 사용. 컨티뉴가 없으면 사용 x
   // 아래 있는 for문에 동작
   for (int k = 0; k < 5; k++){
       for (int j = 0; j < 5; j++){
           if(k == 3){
               System.out.println("----continue called");
               continue loop1;
             	// 
           }
           System.out.printf("%d * %d = %d\n",k , j, k * j);
       }
   }
   ```



