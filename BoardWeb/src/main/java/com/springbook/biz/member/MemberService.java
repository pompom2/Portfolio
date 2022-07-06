package com.springbook.biz.member;

public interface MemberService {
	
	void insertMember(MemberDTO dto);
	void updateMember(MemberDTO dto);
	void deleteMember(MemberDTO dto);
	MemberDTO getMember(MemberDTO dto);

}
