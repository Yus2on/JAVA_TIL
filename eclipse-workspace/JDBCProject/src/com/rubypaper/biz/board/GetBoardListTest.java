package com.rubypaper.biz.board;

import java.util.List;

public class GetBoardListTest {
	public static void main(String[] args) {
		// 1. 글 목록 검색 기능 처리 
		BoardDAO boardDAO = new BoardDAO();
		
		// getBoardList() 메서드가 리턴한 글 목록을 원하는 형태로 사용한다. 
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		// select  기능의 메서드는 반드시 반환 타입이 void 여서는 안됨 -> 검색 결과를 클라이언트로 리턴해줘야 함 
		// 어떻게 쓸지는 클라이언트가 결정해야지 dao가 결정해서는 안됨 
		
		
		// case 1 
//		System.out.println("[ BOARD LIST ]");
//		for(BoardVO board : boardList) {
//			System.out.println(" --> " + board.toString());
//		}
		
		// case 2
		System.out.println("검색된 게시글 수 :" + boardList.size());
		
		//boardDAO.getBoardList();
		
		
		/*
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 객체를 메모리에 로딩한다.
//            DriverManager.registerDriver(new org.h2.Driver());
//            애를이용하면 이 클래스가 패키지에 없으면 아예 컴파일부터 안된다.

			Class.forName("org.h2.Driver");
			// 문자열로 등록하는 방법 결과는 같음. 실제프로젝트에선 이걸 더 많이 씀 간결해서

			// 2. 커넥션을 획득한다.
			String url = "jdbc:h2:tcp://localhost/~/test";
			conn = DriverManager.getConnection(url, "sa", "");// 연결 객체를 반환받는다.
			if (conn != null) {
				System.out.println(conn);
			}

			// 3. SQL전달 객체(Statement)를 생성한다.
			stmt = conn.createStatement();

			// 4. SQL을 전송한다.
			String sql = "select * from board order by seq desc";
			rs = stmt.executeQuery(sql); // select일 때 사용함 rs으로 반환함. 결과 집합

			// 5. 검색 결과 처리(SELECT 구문에 한하여 해당된다.)
			System.out.println("[ BOARD LIST ]");
			while (rs.next()) { // 커서를 밑으로 한 칸 내려줌
				// 읽을 데이터가 없으면 false, 있으면 true 를 반환하기 때문에 무한루프 x
				// 이게 없으면 각 컬럼의 값을 읽으려고 할 때 데이터가 없는 영역이라는 에러 출력

				System.out.println(rs.getInt("SEQ") + " : ");
				System.out.println(rs.getString("TITLE") + " : ");
				System.out.println(rs.getString("WRITER") + " : ");
				System.out.println(rs.getString("CONTENT") + " : ");
				System.out.println(rs.getDate("REGDATE") + " : ");
				System.out.println(rs.getInt("CNT"));
				// 데이터 타입에 따라 사용하는 메서드가 달라져야 함
				// 컬럼이름 대소문자 구분 안함 ( 대소문자 섞어 써도 실행에 문제 없음 ) -> 가독성측면에서 대문자로 쓰는 것이 좋음
				// 컬럼이름을 모를 때는 숫자로 1 2 3 4 5로 선택할수 있음 (= 컬럼의 위치 선택 ) -> 하지만 가독성 떨어져서 유지보수 힘듦

			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
 */
	}
}
