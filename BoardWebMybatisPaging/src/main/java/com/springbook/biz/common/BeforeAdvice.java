package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

//@Service
//@Aspect
public class BeforeAdvice {
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); 	// 비즈니스 메소드 이름
		Object[] args = jp.getArgs();					// 비즈니스 메소드 매개 변수
		
		System.out.println("[사전 처리] " + method + "() 메소드, 매개 변수 정보: " + args[0].toString());
		// System.out.println("[사전 처리] 비즈니스 로직 수행 전 동작");
	}
}
