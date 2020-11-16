package com.rubypaper.biz.board;

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
            // 오라클 드라이브, h2 드라이브는 다 다름. 각 드라이브를 등록해야 각 디비와 연결 가능
            // new org.h2.Driver() -> 드라이브로 등록

            // 방법 1
            // 클래스가 패키지에 없을 때 바로 컴파일 불가능 -> 실행하기 전 문제 인지 가능 (클래스 패스에 해당 라이브러리 등록 필요)
            // 더 안전하다는 장점
            // DriverManager.registerDriver(new org.h2.Driver());

            // 방법 2 -> 실제프로젝트에서 더 많이 사용
            // 문자열로 클래스 경로를 알려주면 클래스 경로를 찾아서 메모리에 올림
            // 클래스 이름에 오타가 있어도 컴파일이 됨 -> sql 객체 생성을 할 때 클래스 이름이 잘못되었다고 알려줌
            // 라이브러리가 없어도 컴파일이 됨
            // Class.forName("new org.h2.Driver()");
            // DriverManager.deregisterDriver(new org.h2.Driver()); , Class.forName("org.h2.Driver()");
            // 기능적으로는 동일 함

            // 2. 커넥션을 획득한다
            // 커넥션 객체 획득시, JDBC url, id, pwd -> 디비 사용자명, 비밀번호, URL 과 일치 필요
            // JDBC url 은 오라클, mysql 다 DBMS 마다 다름
            // JDBC url 모를 땐 디비 관리자한테 연락
            // localhost == 나의 IP 주소
            // (특정 디비로부터,) h2와 연결된 커넥션 객체 생성
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