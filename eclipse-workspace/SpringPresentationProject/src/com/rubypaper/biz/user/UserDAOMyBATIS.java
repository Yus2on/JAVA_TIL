package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO(Data Access Object) 클래스
public class UserDAOMyBATIS implements UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// USER 테이블 관련 CRUD 기능의 메소드
	// 사용자 등록 
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 insertUser() 기능  처리");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	// 사용자 목록 조회 
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 getUser() 기능  처리");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	
}




