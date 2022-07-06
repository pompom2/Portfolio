package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;

//@Service
//@Aspect
public class AfterReturningAdvice {	
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		/*
		if (returnObj instanceof MemberDTO) {
			MemberDTO member = (MemberDTO)returnObj;
		}
		*/
		System.out.println("[사후 처리]" + method + "() 메소드, 리턴값" + returnObj.toString());
		// System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
	}
}
