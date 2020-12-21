# TIL (Today I Learned)
## @OneToMany [1 : N]

- 1:N 관계에서는 1 이 연관관계의 주인 -> 1 쪽에서 외래키를 관리하겠다는 의미가 된다.

- 표준스펙에서 지원은 하지만 실무에서 이 모델은 권장하지 않는다.

- **일대다 단방향** 매핑

- @OneToMany 에는 @JoinClumn을 쓰지 않는다.

  - mappedBy 속성을 이용해서 외래키를 관리하지 않는다고 명시 필요

  ![OneToMany 단점 검색 결과](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FKdhFc%2FbtqFUShqOFV%2FGKapVHu0pyB0OjLPFgXKk0%2Fimg.png)

<br>

## @JoinColumn

- 해당하는 객체를 참조하는 외래키를 만들어 준다. 

- 여기서 join 은 "테이블을 조인하다" 의 조인이 아니라  **참여하다의 조인** 

- 속성 name 은 외래키 이름을 어떻게 정할지 지정해주는 것이지 매핑하는 것이 아니다. 

  - 아무것도 지정하지 않으면 해당 객체의 기본키 값으로 참조할 필드를 만든다.

  ```JAVA
  @Entity
  public class Review {
    ...
      
    @ManyToOne
      @JoinColumn(name = "member_id")
      private Member member;
    
    ...
  }
  ```

<br>

## @ManyToOne [N : 1]

* 가장 많이 사용 된다.
* 외래키가 있는 곳에 참조를 걸고 연관관계 매핑을 한다. -> DB입장에서 보면 당연히 N 에서 FK가 있어야 한다.
* N 쪽에 해당하는 엔티티가 부모엔티티라고 하면 이 부모 엔티티에 casecade를 걸어주면 부모 엔티티가 생성이 될 때 1 에 해당하는 엔티티도 자동으로 생성된다.
* caseCade를 걸어주지 않으면 해당 엔티티와 관련된 엔티티들의 CRUD를 진행할 수 없다.