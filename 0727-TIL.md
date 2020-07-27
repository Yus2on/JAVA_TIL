## TIL(Today I Learned)

- https://github.com/ai-creatv/java-jbd1

  - 소프트웨어 툴 설치 및 Git 설치/설정

  - ```bash
    $ git config --global user.name "유저이름"
    $ git config --global user.email 유저@이메일.com
    ```

    user name, email 수정 시에도 동일하게 사용

#### IntelliJ 설정 

- Java 프로젝트 생성
  - 변수(Variable)의 선언, 변수의 데이터 타입

  - ```` java
    int x; // 변수 선언
    x = 10; // 10 -> 리터럴 // 할당
    System.out.println(x);
    
    int y, z, value; // 한 번에 여러 변수 선언 가능
    
    int valueOne = 10; // 변수 선언과 동시에 할당 가능
    int valueTwo = 20;
    
    int valueThree = 100, valueFour = 1000; // 같은 데이터 타입일 때 변수 선언, 할당
    
    ````

  - ```` java
    // Code Convention
    int valueOfComputer;
    int camelCase;
    int lowerCamelCase;
    int UpperCamelCase;
    ````

  - ```` java
    // Overflow
    short shortValue = (short)64000;
    ````

    

  - | 대상                                 | 내용                                                    |
    | ------------------------------------ | ------------------------------------------------------- |
    | 변수명                               | 의미있는 내용을 사용하여 변수의 용도를 알 수 있게 한다. |
    | 클래스, 인터페이스, Enum, 애너테이션 | PascalCase                                              |
    | 변수, 메소드                         | camalCase                                               |
    | 상수                                 | CONSTANT_NUMBER                                         |



## 오늘의 과제

- 이력서 클래스

  - 현재 신입 채용하고 있는 회사 중에 관심 있는 업종의 회사 1개를 정하기
  - 그 회사의 채용공고 가져오기
  - 그 회사가 속한 산업의 동향 , 회사 서비스의 강점, 최근 뉴스 , 인재상, 동호회, 문화 조사 해오기

- Java

  -  #### Main

    - Markdown 사용법 익히기
    - Github Repository에 업로드 (java 소스 코드 및 Markdown 활용)

  - #### Sub

    - 강의 Repository -> Issue에 질문 하나씩 남기기

  

  

  



