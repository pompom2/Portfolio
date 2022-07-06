package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

//@Service
//@Aspect
public class AfterThrowingAdvice {	
	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[예외 처리] " + method + "() 메소드, 예외 처리 메세지: " + exceptObj.getMessage());
		// System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
