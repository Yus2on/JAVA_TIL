package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class UserDAOSpring implements UserDAO {
	@Autowired
	private JdbcTemplate spring;
	
	// USERS 테이블 관련 SQL 명령어
	private static final String USER_INSERT     = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET        = "SELECT * FROM USERS WHERE id = ? AND PASSWORD = ?";

	// USERS 테이블 관련 CRUD 기능의 메서드
	// 회원 등록
	public void insertUser(UserVO vo) {
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}
}