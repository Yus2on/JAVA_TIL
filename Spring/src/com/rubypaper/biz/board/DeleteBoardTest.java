package com.rubypaper.biz.board;

import java.sql.*;

public class DeleteBoardTest {
	public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. 드라이버 객체를 메모리에 로딩한다.
        	try {
				Class.forName("new org.h2.Driver()");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // 2. 커넥션을 획득한다
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3. SQL전달 객체(Statement)를 생성한다.
            stmt = conn.createStatement();

            // 4. SQL을 전송한다.
            String sql = "delete board where seq = 3";
            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt + "건의 데이터 처리 성공!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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
