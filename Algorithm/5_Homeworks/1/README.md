- # Homework #1

  ## Programmers Level1 획득

  ![Homework#1.png](https://github.com/Yus2on/JAVA_TIL/blob/master/Algorithm/5_Homeworks/1/img/Homework%231.png?raw=true)

  

  <br>

  

  -------

  ## 제출 사항

  ### [문자열 내 p와 y의 개수](https://programmers.co.kr/learn/courses/30/lessons/12916)

  ```java
  class Solution {
    boolean solution(String s) {
      boolean answer = true;
  
      // 문자열 내에서 p와 y가 있을 때마다 카운트 할 변수
      int pCnt = 0, yCnt = 0;
  
      for(int i = 0; i < s.length(); i++) {
        // 문자열 s에서 i 번째 문자가 'p' || 'P' 일 때 pCnt를 1 증가
        if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
          pCnt ++;
  
          // 문자열 s에서 i 번째 문자가 'y' || 'Y' 일 때 yCnt를 1 증가
        } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
          yCnt ++;
        }
      } // end for
  
      // 문자열에서 문자 p, y 가 하나도 없었다면 true 반환
      if(pCnt == 0 && yCnt == 0) {
        return true;
      }
  
      // 문자열에서 문자 p, y의 수가 같다면 true, 아니면 false 반환
      return (pCnt == yCnt) ? true : false;
    }
  }
  ```

  <br>

  ### [최대공약수와 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12940)

  ```java
  class Solution {
    public int[] solution(int n, int m) {
      int [] answer = new int [2]; // 배열의 길이 2로 지정
  
      // 입력받은 n, m 비교해서 작은 걸 small, 큰 걸 big에 저장
      int small = Math.min(n, m);
      int big = Math.max(n, m);
  
      // 최대공약수 큰 수 % 작은 수가 0이 될때까지 반복
      while (big % small != 0) {
        // 기존 큰 수 % 작은 수를 tmp 에 저장
        int tmp = big % small;
        // 작은 수를 큰 수에 저장
        big = small;
        // tmp를 작은 수에 저장
        small = tmp;
      } // end while
  
      // big % small == 0 일 때 -> small 이 두 수의 최대공약수
      // 최소공배수는 (두 수의 곱) / 최대공약수
      answer[0] = small;
      answer[1] = (n * m ) / small;
  
      return answer;
    }
  }
  
  ```

  