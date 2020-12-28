# TIL (Today I Learned)

## 스프링 부트 프로젝트 구조

- src.main.java : 자바 소스코드

  ![프로젝트 구조 - java](https://media.vlpt.us/post-images/max9106/95071e90-450b-11ea-b00e-cfcf2d532bad/-2020-02-02-12.56.06.png)

- src.main.resources : 자바 코드를 제외한 모든 것

  - **resources 디렉토리를 root라고 생각하고 자바 application에서 resources 하위 항목들을 모두 참조할 수 있다.**

  ![프로젝트 구조 - resources](https://media.vlpt.us/post-images/max9106/99096cf0-450b-11ea-b00e-cfcf2d532bad/-2020-02-02-12.56.24.png)

- src.main.test : 테스트 코드

  - 메인 클래스(@SpringBootApplication)를 가장 최상위 패키지 하위에 두는 것을 추천한다.(java 바로 아래에 두면 모든 패키지를 다 스캔하기 때문)

  ![프로젝트 구조 - test](https://media.vlpt.us/post-images/max9106/9fd3dc00-450b-11ea-bc90-a1015e18ffb0/-2020-02-02-12.56.40.png)![테스트 메인 클래스](https://media.vlpt.us/post-images/max9106/2dcfeea0-450b-11ea-bc90-a1015e18ffb0/-2020-02-02-12.53.46.png)