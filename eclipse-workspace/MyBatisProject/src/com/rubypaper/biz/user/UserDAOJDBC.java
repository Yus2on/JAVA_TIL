package com.rubypaper.biz.user;

// DAO(Data Access Object) 클래스
public class UserDAOJDBC {

	// USERS 테이블 관련 SQL 명령어
	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET    = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 insertUser() 기능 처리");
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 getUser() 기능 처리");
		return null;
	}	
}




