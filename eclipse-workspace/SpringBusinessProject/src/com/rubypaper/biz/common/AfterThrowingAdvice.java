package com.rubypaper.biz.common;

import java.sql.SQLException;

public class AfterThrowingAdvice {

	public void exceptionLog(Exception exceptionObj) {
		System.out.println("[ 예외 처리 ] 비즈니스 메소드 수행 중 예외 발생");
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0번 게시 글을 등록할 수는 없습니다.");
		} else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수 없습니다.");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL 구문에 오류가 있습니다.");
		} else {
			System.out.println("문제 발생!! 잠시 시스템을 종료합니다.");
		}
	}
}
