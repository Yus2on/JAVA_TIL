package com.rubypaper.biz.user;

public class GetUserTest {
	public static void main(String[] args) {
		// 1. 회원가입 기능 테스트 
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		
		vo.setId("guest");
		vo.setPassword("guest123");
		vo.setName("방문자");
		vo.setRole("USER");
		//userDAO.insertUser(vo);
		// Id가 프라이머리키라서 한 번이상 실행하면 막힘 중복에 걸려서 
		// 재실행하고 싶으면 insertUser 를 주석처리 하고 실행할 필요 있음 
		
		// 2. 회원 상세 조회 기능 테스트 
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + " 님 횐영합니다. 로그인 성공 ");
		} else {
			System.out.println(vo.getId() + " 로그인 실패 ");
		}
		
		
		/*
		// JDBC API 선언
		Connection conn = null; // 고속도로
//		Statement stmt = null; // 자동차 
		PreparedStatement stmt = null; // 자동차(페라리) statement보다 sql처리속도가 5배 이상 빠르다. 무조건 써라.
		ResultSet rs = null; // 검색 결과 저장
		
		try {
			// 2.Connection 객체를 획득한다.
			conn = JDBCUtil.getConnection(); // static 메소드니깐 바로 접근이 가능하다.
			
			// 3. Statement 객체를 획득한다.
			String sql = "select * from users where id = ? and password = ?";
			stmt = conn.prepareStatement(sql);// 프리페얼드는 여기에 sql이 들어감 그리고 파라미터가 ?로 바뀐다. exe여기에 sql이 빠짐
			
			// ?(= 파라미터)에 값 설정
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");  
			// 결과가 달라지지 않지만 성능이 더 좋아진다.
			
			// 4. SQL 구문을 DB에 전송한다.
			rs = stmt.executeQuery();
			
			// 5. 검색 결과 처리
			if(rs.next()) {
				System.out.println("아이디 : " + rs.getString("ID"));
				System.out.println("비번 : " + rs.getString("PASSWORD"));
				System.out.println("이름 : " + rs.getString("NAME"));
				System.out.println("권한 : " + rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		*/
	}
}

