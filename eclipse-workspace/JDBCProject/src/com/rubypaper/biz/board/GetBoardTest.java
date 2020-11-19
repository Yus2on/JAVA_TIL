package com.rubypaper.biz.board;

public class GetBoardTest {
	public static void main(String[] args) {
		// 1. 글 상세 조회 기능 처리 
		BoardDAO boardDAO = new BoardDAO();
		// boardDAO.getBoard(1);
		BoardVO vo = new BoardVO();

		vo.setSeq(2);
		boardDAO.updateBoard(vo);
		BoardVO board = boardDAO.getBoard(vo);
		
		System.out.println(board.getSeq() + "번 게시글의 상세 정보");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("작성자 : " + board.getWriter());
		System.out.println("내용 : " + board.getContent());
		System.out.println("등록일 : " + board.getRegDate());
		System.out.println("조회수 : " + board.getCnt());
		
		

		/*
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 객체를 메모리에 로딩한다.
            DriverManager.registerDriver(new org.h2.Driver());
            // 얘를 이용하면 이 클래스가 패키지에 없으면 아예 컴파일부터 안된다.

			Class.forName("org.h2.Driver");
			// 문자열로 등록하는 방법 결과는 같음. 실제프로젝트에선 이걸 더 많이 씀 간결해서

			// 2. 커넥션을 획득한다.
			String url = "jdbc:h2:tcp://localhost/~/test";
			conn = DriverManager.getConnection(url, "sa", "");// 연결 객체를 반환받는다.

			// 3. SQL전달 객체(Statement)를 생성한다.
			stmt = conn.createStatement();

			// 4. SQL을 전송한다.
			String sql = "select * from board where seq = 1";
			// CRUD -> Creat Read Update Delete
			rs = stmt.executeQuery(sql); // select일 때 사용함 rs으로 반환함. 결과 집합

			// 5. 검색 결과 처리(SELECT 구문에 한하여 해당된다.)
			System.out.println("[ BOARD LIST ]");
			if (rs.next()) { // 검색결과가 있다면 // 조건식으로 하나만 나오도록 해줘서 if문으로 바꾼다.
				// 커서를 밑으로 한 칸 내려줌
				// 읽을 데이터가 없으면 false, 있으면 true 를 반환하기 때문에 무한루프 x
				// 이게 없으면 각 컬럼의 값을 읽으려고 할 때 데이터가 없는 영역이라는 에러 출력

				System.out.println("게시글 상세 정보");
				System.out.println("번호 :" + rs.getInt("SEQ") + " : ");
				System.out.println("제목 :" + rs.getString("TITLE") + " : ");
				System.out.println("작성자 :" + rs.getString("WRITER") + " : ");
				System.out.println("내용 :" + rs.getString("CONTENT") + " : ");
				System.out.println("등록일 :" + rs.getDate("REGDATE") + " : ");
				System.out.println("조회수 :" + rs.getInt("CNT"));
				// 데이터 타입에 따라 사용하는 메서드가 달라져야 함
				// 컬럼이름 대소문자 구분 안함 ( 대소문자 섞어 써도 실행에 문제 없음 ) -> 가독성측면에서 대문자로 쓰는 것이 좋음
				// 컬럼이름을 모를 때는 숫자로 1 2 3 4 5로 선택할수 있음 (= 컬럼의 위치 선택 ) -> 하지만 가독성 떨어져서 유지보수 힘듦
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 커넥션 꼭 닫아줘야 함 -> 역순으로 닫아야 함
			// close 순서 ResultSet => Statement -> Connection
			// REsulteSet 에서 오류나면 아래 Statement, Connection 는 실행도 안될 수 있기 때문에
			// 각각 처리
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}

			// 커넥션은 오류가 발생할 수 있기 때문에 close 인지 상태체크 필요함
			// 다른 건 해줘도 되고 안해도 됨
			try {
				if (!conn.isClosed() && conn != null) { // 커넥션이 닫힌 상태가 아니라면
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}

		}
 * */
	}
}
