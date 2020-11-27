package com.rubypaper.biz.common;

import com.rubypaper.biz.user.UserVO;

public class AfterReturningAdvice {

	public void afterLog(Object returnObj) {
		System.out.println("[ 사후 처리 ] 비즈니스 메소드 리턴 값 : " + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "님은 관리자 화면으로 바로 이동.....");
			}
		}
	}
}
