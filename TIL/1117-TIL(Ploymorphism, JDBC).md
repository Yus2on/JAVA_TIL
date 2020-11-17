## 다형성(Polymorphism)

### 디폴트 생성자 (Default constructor)

- 생성자 중 매개변수가 없는 생성자
- 원래 생성자의 역할은 객체가 생성될 때 객체의 멤버변수 값을 의미 있는 값으로 초기화 할 때 사용
- *Primitive Type*(원시타입) 은 각 타입의 디폴트 값, *Reference Type*(참조형) 은 `null`  로 초기화 
- 디폴트 생성자 내 코드의 양과 복잡도는 상관 없이 외부에서 값을 받아오지 못하기 때문에 멤버 변수를 디폴트 값으로 초기화 할 수 밖에 없어서 디폴트 생성자라고 함  (= 디폴트로 생겨서 디폴트 생성자가 아님)

```java
public class SamsungTV {
	public SamsungTV() {
    // default constructor
  }
  
  public void powerOn(){ ... }
  
  public void powerOff() { ... }
}        
```

<br>

<br>

### 다형성 

- 다형성  = 상속 + 오버라이딩(Overriding) + 형변환
- one interface multiple implementation
  - 하나의 인터페이스를 사용하여 다양한 구현 방법을 제공
- 사용자 입장에서 객체를 다 파악하고 생성하는 대신 대표되는 하나의 타입으로 핸들링하고 싶다
- 클라이언트 소스만 봐서는 뭐가 실행될 지 알 수 없게끔 만들어져야 함 
- 클래스를 통으로 바꿔치기 하면서 재사용하기 위해선 다형성 필요 -> 객체지향 언어의 핵심은 다형성
- 최상위 인터페이스를 구현하고 하위 클래스들이 존재할 때, 다형성은 하위 클래스의 메서드에 접근할 때 최상위 인터페이스를 통해서 접근 -> 제대로 된 클래스 설계만 한다면 구현은 어떻게 되었는지 상관하지 않고 **일관된 사용 방법 제공**

```java
public interface TV {
  void powerOn();

  void powerOff();

  void volumeUp();

  void volumeDown();
}
```

<center>interface TV</center>

<br>

```java
public class LgTV implements TV {
	public LgTV() {
    System.out.println("==> LgTV 생성");
  }

  @Override
  public void powerOn() {
    System.out.println("LgTV --- 전원 켠다.");
  }

  @Override
  public void powerOff() {
    System.out.println("LgTV --- 전원 끈다.");
  }

  @Override
  public void volumeUp() {
    System.out.println("LgTV --- 소리 올린다.");
  }

  @Override
  public void volumeDown() {
    System.out.println("LgTV --- 소리 내린다");
  }
}
```

<center>class LgTV</center>

<br>

```java
public class SamsungTV implements TV {
  @Override
  public SamsungTV() {
    System.out.println("==> SamsungTV 생성");
  }
  
  public void powerOn() {
    System.out.println("SamsungTV --- 전원 켠다.");
  }

  @Override
  public void powerOff() {
    System.out.println("SamsungTV --- 전원 끈다.");
  }

  @Override
  public void volumeUp() {
    System.out.println("SamsungTV --- 소리 올린다.");
  }

  @Override
  public void volumeDown() {
    System.out.println("SamsungTV --- 소리 내린다");
  }

}
```

<center>class SamsungTV</center>

<br>

```java
public class TVUser {
    public static void main(String[] args) {
        TV tv = new SamsungTV(); // 객체 생성
        // 객체 메서드 호출
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
```

<center>class TVUser (클라이언트 소스)</center>

<br>

<br>

### BeanFactory

- Bean = 객체, 객체 공장
- 다형성을 이용하면 클라이언트 소스 수정 필요 -> 디자인 패턴의 사용 
- Factory pattern (디자인 패턴)
  - 객체 생성을 위한 인터페이스를 정의할 때 어떤 클래스의 인스턴스를 만들지는 서브 클래스에서 결정
- 소스 수정 -> 컴파일 -> 서버에 올리는 일련의 작업이 필요하기 때문에 소스 수정을 최소화 시키는 방향
- 다형성, 디자인 패턴을 사용해도 해결되지 않은 문제를 해결하는 것 => **스프링프레임워크**
  - 유지보수할 때 자바 소스를 건드리지 않아 컴파일을 다시 할 필요가 없다.

```java
public class BeanFactory {
  public Object getBean(String id) {
    if(id.equals("lg")) {
      return new LgTV();
    } else if(id.equals("samsung")) {
      return new SamsungTV();
    } else if(id.equals("google")) { // 뭔가 변경하거나 확장해야 할때 추가 / 제거 필요 
      return new GoogleTV();
    }
    return null;
  }
}
```

<center>class BeanFactory</center>

<br>

```java
public class TVUser {
    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        TV tv = (TV) factory.getBean(args[0]);
        // run - edit configuration - Program arguments 에서 아규먼츠 넣어줌
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
```

<br><br><br>

## JDBC (Java Database Connectivity)

### H2 database

- 자바로 작성된 오픈소스 관계형 데이터베이스 관리 시스템 (RDBMS)
  - RDB -> 관계형 데이터 베이스
- MySql, Orcal에 비해 저용량. 가볍고 빠르며 JDBC API 지원 

<br>

#### H2DB 설치

- 자바 기반의 DBMS기 때문에 자바 설치 필요

- [H2](http://h2database.com) 접속

- All Platforms 다운로드

  ![](https://user-images.githubusercontent.com/46306263/99340207-eaa32f80-28ca-11eb-8eb2-1faa58fa1395.png)

<br>

#### H2DB 서버 구동

- 다운받은 압축 파일을 풀고 하위의 bin/h2w.bat 파일 실행

  ```shell
  # MacOS
  $ cd /bin
  $ ./h2.sh
  ```

- 서버가 구동되면서 웹 기반 H2 콘솔 실행. Connect 누르면 쿼리 입력 및 실행 가능

- jdbc:h2:tcp://localhost/~/test -> 원격 접속 

  ![](https://user-images.githubusercontent.com/46306263/99340571-9ea4ba80-28cb-11eb-9987-0b44675531c2.png)

<br>

### IntelliJ & H2

- File - Project Structure - Libraries - h2/bin/xx.jar file => External Libraries 

```mysql
create table board (
  seq number(5) primary key,
  title varchar2(200),
  writer varchar2(200),
  content varchar2(200),
  regdate date default sysdate,
  cnt int(5) default 0
);
```

<center>board 테이블 생성</center>

<br>

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBoardTest {
  public static void main(String[] args) {
    Connection conn = null; // 인터페이스
    Statement stmt = null; // 인터페이스

    try {
      // 1. 드라이버 객체를 메모리에 로딩한다.
      // new org.h2.Driver() -> 드라이브로 등록
      // case 1 : 클래스가 패키지에 없을 때 바로 컴파일 불가능 -> 실행하기 전 문제 인지 가능 (클래스 패스에 해당 라이브러리 등록 필요) 더 안전하다는 장점
      DriverManager.registerDriver(new org.h2.Driver());

      // case 2 -> 실제프로젝트에서 더 많이 사용. 문자열로 클래스 경로를 알려주면 클래스 경로를 찾아서 메모리에 올림. 
      // 클래스 이름에 오타가 있어도 컴파일이 됨 -> sql 객체 생성을 할 때 클래스 이름이 잘못되었다고 알려줌
      // 라이브러리가 없어도 컴파일이 됨
      Class.forName("new org.h2.Driver()");


      // 2. 커넥션을 획득한다
      String url = "jdbc:h2:tcp://localhost/~/test";
      conn = DriverManager.getConnection(url, "sa", "");

      // 3. SQL전달 객체(Statement)를 생성한다.
      stmt = conn.createStatement();

      // 4. SQL을 전송한다.
      String sql = "insert into board(seq, title, writer, content) "
        + "values((select nvl(max(seq), 0) +1 from board), '테스트제목', '테스터', '테스트 내용....')";
      int cnt = stmt.executeUpdate(sql);
      System.out.println(cnt + "건의 데이터 처리 성공!!");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      // Statemnet -> Connetion
      try {
        if(stmt != null)
          stmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      finally {
        stmt = null;
      }
      try {
        if(!conn.isClosed() && conn != null)
          conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        conn = null;
      }
    }
  }
}
```

- MySql, Orcal, H2 등 드라이브는 다 다르기 때문에 각 드라이브를 등록해야 DB 연결 가능

  - JDBC API - java.sql 패키지 인터페이스가 많음 -> 이 인터페이스를 구현한 게 JDBC Driver (DB 개발자들이 개발)

- JDBC url도 MySql, Orcal, H2 등 DBMS 마다 다름

- localhost == 나의 IP 주소 

- H2 드라이버 객체를 메모리 로딩 -> 특정 드라이버로부터 연결을 얻음 -> 연결로부터 Statement 클래스를 얻음 

- **close 필수**

  - ResultSet => Statement => Connection 역순으로 close
  - REsulteSet 에서 오류나면 아래 Statement, Connection 는 실행도 안될 수 있기 때문에 각각 처리
  - 등록, 수정, 삭제는 ResultSet 사용 하지 않았기 때문에 제외
  - Connection은 오류가 생길 수 있어서 끊어진 상태인지 먼저 체크 필요 (나머지는 체크해도 되고 안 해도 됨)

  ```java
  finally {
    try {
      if(rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      rs = null;
    }
  
    try {
      if(stmt != null) {
        stmt.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      stmt = null;
    }
  
    try {
      if(!conn.isClosed() && conn != null) {  // 커넥션이 닫힌 상태가 아니라면
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      conn = null;
    }
  
  }
  ```

  