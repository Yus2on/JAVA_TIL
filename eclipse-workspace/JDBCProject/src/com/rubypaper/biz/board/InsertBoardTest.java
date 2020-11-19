package com.rubypaper.biz.board;

public class InsertBoardTest {
	public static void main(String[] args) {
		// 1. 글 등록 기능 처리 
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("제목");
		vo.setWriter("작성자");
		vo.setContent("vo 내용........");
		boardDAO.insertBoard(vo);
		// boardDao만 작성 했을 때 문제점
		// 1. 처음볼 때 들어가는 값이 제목인지 컨텐츠인지 모름 -> 이 메소드를 들어가봐야 의미를 파악 가능 
		// 2. 파라미터의 타입과 순서만 맞으면 데이터가 잘못 들어가도 들어가게 된다. 
		//    에러가뜨고 컴파일 오류가 뜨면 다행인데 안 뜨고 잘못 들어가면 문제가 된다.
		
		
		// 2. 글 목록 검색 기능 처리
		boardDAO.getBoardList();
		
		
		/*
		Connection conn = null; // 인터페이스
		PreparedStatement stmt = null;
		//Statement stmt = null; // 인터페이스

		try {
			// 3. SQL전달 객체(Statement)를 생성한다.
			//stmt = conn.createStatement();
			String sql = "insert into board(seq, title, writer, content) "
					+ "values((select nvl(max(seq), 0) +1 from board), ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			// 파라미터 셋팅 
			stmt.setString(1, "JDBC  제목 ");
			stmt.setString(2, "테스터");
			stmt.setString(3, "JDBC 내용.........");
			
			// 4. SQL을 전송한다.
			int cnt = stmt.executeUpdate(); 
			System.out.println(cnt + "건의 데이터 처리 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		*/
	}
}
