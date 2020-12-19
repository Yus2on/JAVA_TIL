# TIL (Today I Learned)

## @Entity

- `@Entity` 어노테이션이 붙은 클래스는 JPA가 관리하는 클래스
- 해당 클래스를 엔티티라고 부른다. 
- JPA를 사용하여 테이블과 매핑 할 클래스는 반드시 `@Entity`를 선언해야한다.

### 특징

- 기본 생성자가 필수로 필요하다.
  - public 또는 protected 생성자이어야 한다.( = private은 안됨)
  - JPA 스팩으로 규정되어있다. -> JPA를 구현해서 쓰는 라이브러리들이 reflection과 같은 다양한 기술을 사용해서 객체를 프록싱할 때 기본 생성자가 필요하기 때문 
- `final, enum, interface, inner`클래스는 엔티티가 될 수 없다.
- 데이터베이스에 저장하고 싶은 필드는 `final`을 선언할 수 없다.

### 속성

- name (String, Optional)
  - `@Entity(name = "ARTICLE")`
  - JPA에서 사용할 엔티티 이름을 지정한다. (기본값은 클래스 이름)
  - 엔티티 중 같은 이름이 없다면 기본값을 사용하는 것이 좋다.



<br>

## @Table

- 엔티티 와 매핑할 테이블을 지정한다.

### 속성

- name(String, Optional) : 매핑할 테이블 이름을 지정한다. (기본값은 엔티티 이름)
- catalog(String, Optional) : 데이터베이스 catalog를 매핑한다.
- schema(String, Optional) : 데이터베이스 schema를 매핑한다.
- indexes(Index[], Optional) : 데이터베이스 인덱스를 매핑한다.
- uniqueConstraints(UniqueConstraint[], Optional) : DDL 생성 시 유니크 제약조선을 생성한다.

<br>

### @Id / @GeneratedValue

- `@id` 는 Primary Key 지정하고 `@GeneratedValue`는 기본키를 생성하는 방법을 지정한다.
-  `@GeneratedValue` 는 `@Id` 어노테이션과 같이 선언

#### 속성

- generator(String, Optional) : `@SequenceGenerator`, `@TableGenerator`에서 명시된 기본키 생성기 이름
- strategy(GenerationType, Optional) : 기본키 생성 전략
  - `GenerationType.AUTO`: 방언에 따라 나머지 세 가지 전략을 자동으로 지정한다.(기본값)
  - `GenerationType.IDENTITY`: 기본 키 생성을 데이터베이스에 위임한다.
    - id 값을 null로 하면 DB가 알아서 **AUTO_INCREMENT** 를 수행.
  - `GenerationType.SEQUENCE`: 데이터베이스 Sequence Object를 사용한다.
    - DB Sequence는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트
    - DB가 자동으로 숫자를 만들어준다.
    - `@SequenceGenerator`가 필요하다.
  - `GenerationType.TABLE`: 키 생성 전용 테이블 하나를 만들어 데이터베이스 Sequence 를 흉내내는 전략
    - `@TableGenerator`가 필요하다.

### @Column

- Column을 매핑한다.

#### 속성

- columnDefinition(String, Optional)
- 직접 column 정보를 작성할 수 있다.
- `@Column(columnDefinition = "varchar(100) default 'EMPTY'")`
- insertable(boolean, Optional)
- length(int, Optional) : 문자 길이를 제한한다. String 타입에만 사용.
- name(String, Optional) : DB 컬럼명을 지정. 기본값은 해당 객체명.
- nullable(boolean, Optional) : 컬럼 값이 NULL이 될 수 있는지 선택한다. 기본값은 true
- precision(int, Optional) : 숫자가 엄청 큰 BigDecimal인 경우 사용한다.
- scale(int, Optional) : 숫자가 엄청 큰 BigDecimal인 경우 사용한다.
- table(String, Optional) : 해당 컬럼을 포함하고 있는 테이블의 이름을 설정한다.
- unique(boolean, Optional) : 칼럼을 유니크 키로 할지 선택한다. (= 유일한 값을 가질 지 선택)
  - 잘 사용하지 않는다.
  - `constraint UK_ewkrjwel239flskdfj01 unique (name)`와 같이 이름을 랜덤으로 만든다.
- updatable(boolean, Optional) : 컬렴을 수정했을 때 DB에 추가할 것인지 여부를 선택한다.
  - update 문을 수행할 때 해당 컬럼에 반영할 지 여부
  - `@Column(updatable = false)`시 변경되어도 DB에 반영되지 않는다.

### @JoinColumn

- 조인을 하고 있는 컬럼을 매핑한다.
- `ManyToOne, OneToMany, OneToOne, JoinTable, CollectionTable, ForeignKey` 어노테이션과 주로 같이 사용한다.

<br>

## Reference

- https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html
- https://gmlwjd9405.github.io/2019/08/11/entity-mapping.html
- https://gmlwjd9405.github.io/2019/08/12/primary-key-mapping.html