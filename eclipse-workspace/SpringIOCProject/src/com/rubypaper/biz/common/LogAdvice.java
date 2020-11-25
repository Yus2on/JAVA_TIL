package com.rubypaper.biz.common;

public class LogAdvice {

	public void printLog() {
		// 관심분리는 되었지만 OOP 언어의 한계
		// 메서드 이름이 변경되거나 인자가 추가되면 호출되는 모든 부분 수정 필요
		System.out.println("[ 사전 처리 ] 비즈니스 로직 수행 전 동작");
	}
}
