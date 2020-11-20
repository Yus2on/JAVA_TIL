package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rubypaper.biz.common.JDBCUtil;

//DAO (Data Access Object) 클래스 
public class BoardDAO {
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// BOARD 테이블 관련 SQL 명령어
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT)"
			+ "VALUES((SELECT NVL(MAX(SEQ)) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE =?, CONTENT = ? WHERE SEQ = ?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT = CNT + 1 WHERE SEQ = ?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ = ?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ = ?";
	private static final String BOARD_LIST       = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private static final String BOARD_SEARCH_TITLE = "SELECT * FROM BOARD WHERE TITLE LIKE ? ORDER BY SEQ DESC";
	private static final String BOARD_SEARCH_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE ? ORDER BY SEQ DESC";

	// BOARD 테이블 관련 CRUD 기능의 메서드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection(); // 커넥션 얻음
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle()); // sql이 ? 라서 각 123번 ?를 적절하게 세팅
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
//			stmt.setString(1, title); // sql 세팅 값을 넣어줌.
//			stmt.setString(2, writer);
//			stmt.setString(3, content);

			stmt.executeUpdate(); // 데이터베이스에 전송
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);

		}
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제
	// 유지보수할 때 매개변수가 int seq로 받으면 추가정보를 기입하거나 삭제할 때 하나하나 수정 필요 
	// -> 그래서 vo를 통째로 넣는게 일관성 면에서도 좋다. 유지보수할 때 수정할 필요가 없어진다.
	// 지금은 메모리에 대한 걱정은 없기때문에 vo를 통째로 넣어도 성능적으로 문제가 되지 않는다.
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				// 검색 결과 한 건을 BoardVO 객체에 매핑한다
				// System.out.println(rs.getInt("SEQ") + "번 게시글 내용 : " + rs.getString("CONTENT"));
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				// 검색 결과가 존재하는 경우 조회수 증가 
				stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
				stmt.setInt(1,  vo.getSeq());
				stmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn); // select 니까 rs부터 역순으로 닫아줘야 함
		}
		return board;
	}

	// 글 목록 검색
	// 검색 결과를 얘가 처리하도록 결정하면 안 됨 -> 클라이언트 소스 단에서 이뤄져야 함
	public List<BoardVO> getBoardList(String searchCondition, String searchKeyword) {
		// 비어있는 리스트 컬렉션을 생성한다.
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		// String type = (String)("type");
		// String keyWorkd = (String)listType.get("keyWorkd");
		// int page = (Integer)listType.get(page);
		
		try {
			conn = JDBCUtil.getConnection();
			
			if (searchCondition.equals("none")) {
				// 전체 목록
				stmt = conn.prepareStatement(BOARD_LIST);
			} else if (searchCondition.equals("TITLE")) {
				// 제목 검색 
				stmt = conn.prepareStatement(BOARD_SEARCH_TITLE);
				stmt.setString(1, "%" + searchKeyword + "%");
			} else if (searchCondition.equals("CONTENT")) {
				// 내용 검색 
				stmt = conn.prepareStatement(BOARD_SEARCH_CONTENT);
				stmt.setString(1, "%" + searchKeyword + "%");
			} 
			
			rs = stmt.executeQuery(); // select 
			while (rs.next()) {
				// 검색 결과 한 ROW 당 BoardVO 객체에 매핑한다
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// 검색 결과가 매핑된 BoardVO 객체를 리스트 컬렉션에 등록한다.
				boardList.add(board);
				// System.out.println(rs.getInt("SEQ") + " : " + rs.getString("CONTENT"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		// 검색 결과가 저장된 리스트 컬렉션을 클라이언트로 리턴한다.
		return boardList;
	}
}
