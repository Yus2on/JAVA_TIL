package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;

// 1. VO 클래스 
@Data
public class BoardVO {
	// 테이블의 컬럽 이름(데이터타입까지) 과 동일한 멤버변수를 Private 로  선언한다 
	// 변수명이나 데이터 타입을 바꿨을때, 변수가 추가/삭제 될 떼 문제가 생김
	//  - 이걸 자동으로 처리하기 위해 lombok 사용 
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	
//	// win 단축키 alt shift s 
//	public BoardVO(String title, String writer, String content) {
//		super();
//		this.title = title;
//		this.writer = writer;
//		this.content = content;
//	}
	
	// private 멤버변수에 접근하는 public Getter / Setter 메서드를 작성한다.
	// 단축키 win : alt + shift + s 
	// mac은 없음 단축키..
}
