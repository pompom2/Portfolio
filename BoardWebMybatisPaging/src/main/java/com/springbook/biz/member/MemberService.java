package com.springbook.biz.member;

public interface MemberService {
	
	MemberDTO checkIdMember(MemberDTO dto);
	void insertMember(MemberDTO dto);
	void updateMember(MemberDTO dto);
	void deleteMember(MemberDTO dto);
	MemberDTO getMember(MemberDTO dto);
	MemberDTO loginMember(MemberDTO dto);
	
}
