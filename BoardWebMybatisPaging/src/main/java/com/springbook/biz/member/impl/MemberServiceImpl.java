package com.springbook.biz.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAOMybatis2;
import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAOMybatis2 memberDAO;
	@Autowired
	private BoardDAOMybatis2 boardDAO;

	@Override
	public MemberDTO checkIdMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - checkIdMember()");
		return memberDAO.checkIdMember(dto);
	}
	
	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - insertMember()");
		memberDAO.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - updateMember()");
		memberDAO.updateMember(dto);
	}

	// 회원 탈퇴 시, 회원의 모든 게시글 삭제 -> 트랜잭션 처리
	@Override
	@Transactional("txManager")
	public void deleteMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - deleteMember()");
		memberDAO.deleteMember(dto); // 1번 작업 - 회원 삭제
		
		BoardDTO board = new BoardDTO();
		board.setWriter(dto.getId());
		boardDAO.deleteBoardById(board); // 2번 작업 - 회원의 모든 게시글 삭제
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - getMember()");
		return memberDAO.getMember(dto);
	}

	@Override
	public MemberDTO loginMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl - loginMember()");
		return memberDAO.loginMember(dto);
	}

	
	
}
