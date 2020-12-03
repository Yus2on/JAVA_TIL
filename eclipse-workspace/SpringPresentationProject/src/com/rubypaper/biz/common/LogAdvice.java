package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice {
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
		Object[] args = jp.getArgs(); 				 // 클라이언트가 전달한 인자 정보
		
		// 관심분리는 되었지만 OOP 언어의 한계
		// 메서드 이름이 변경되거나 인자가 추가되면 호출되는 모든 부분 수정 필요
		System.out.println("[ 사전 처리 ] " + method 
				+ "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}

