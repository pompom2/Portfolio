package com.springbook.biz.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberServiceClient {
	
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("boardContext.xml");
		
		// 2. MemberService 객체를 찾음
		MemberService memberService = (MemberService)container.getBean("memberService");
		
		// 3-1. 회원 등록
		MemberDTO member = new MemberDTO();
		/*
		member.setId("bbb2222");
		member.setPassword("1234");
		member.setName("이익준");
		member.setRole("일반사용자");
		memberService.insertMember(member);
		*/
		
		// 3-2. 회원 정보 확인(1건)
		
		member.setId("admin");
		member.setPassword("1234");
		MemberDTO m = memberService.getMember(member);
		System.out.println(m);
		
		// 3-3. 회원 정보 수정
		/*
		member.setId("aaa1111");
		member.setPassword("1234");
		member.setName("채송화");
		member.setRole("관리자");
		memberService.updateMember(member);
		*/
		
		// 3-4. 회원 정보 삭제
		/*
		member.setId("bbb2222");
		member.setPassword("1234");
		memberService.deleteMember(member);
		*/
		
		// 4. Spring 컨테이너 종료
		container.close();
	}

}
