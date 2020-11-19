package com.rubypaper.biz.board;

public class DeleteBoardTest {
	public static void main(String[] args) {
		// 1. 글 삭제 기능 처리
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		// boardDAO.deleteBoard(vo);
		
		// 2. 글 목록 검색 기능 처리 
		boardDAO.getBoardList();
		
		
		/*
		Connection conn = null;
		Statement stmt = null;

		try { // 어느 지역으로 도로를 만들지 지역을 정함
			// 1. 드라이버 객체를 메모리에 로딩한다.
			DriverManager.registerDriver(new org.h2.Driver());
//            Class.forName("new org.h2.Driver()");

			// 2. 커넥션 객체를 획득한다 (= 도로를 만들어 준다 )
			String url = "jdbc:h2:tcp://localhost/~/test";
			conn = DriverManager.getConnection(url, "sa", "");
			//url, id, pw 중요함 

			// 3. SQL전달 객체(Statement)를 생성한다. ( = 도로에 자동차를 만들어 준다 )
			stmt = conn.createStatement();

			// 4. SQL을 전송한다. ( = 자동차에 사람을 태워서 지역으로 보낸다)
			String sql = "delete board where seq = 3";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건의 데이터 처리 성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt !=null) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			} finally { 
				stmt = null; 
			}
			
			try {
				if (!conn.isClosed() && conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

		*/
	}
}
